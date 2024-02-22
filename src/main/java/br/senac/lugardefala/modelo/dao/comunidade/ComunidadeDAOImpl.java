package br.senac.lugardefala.modelo.dao.comunidade;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade_;
import br.senac.lugardefala.modelo.entidade.moderador.Moderador;
import br.senac.lugardefala.modelo.entidade.moderador.Moderador_;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario_;

public class ComunidadeDAOImpl implements ComunidadeDAO {

	private static final SessionFactory sessionFactory;

	static {
		Configuration configuration = new Configuration();

		configuration.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.categoria.Categoria.class);
		configuration.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.conselho.Conselho.class);
		configuration.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.comunidade.Comunidade.class);
		configuration.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.contato.Contato.class);
		configuration.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.denuncia.Denuncia.class);
		configuration.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.denuncia.DenunciaModerador.class);
		configuration.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.denuncia.DenunciaRelato.class);
		configuration.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.denuncia.DenunciaConselho.class);
		configuration.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.denuncia.DenunciaUsuario.class);
		configuration.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.moderador.Moderador.class);
		configuration.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.relato.Relato.class);
		configuration.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.usuario.Usuario.class);
		configuration.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.foto.Foto.class);

		configuration.configure("hibernate.cfg.xml");

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void inserir(Comunidade comunidade) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();
			session.save(comunidade);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao inserir comunidade: " + e.getMessage());
		}
	}

	public void deletar(Comunidade comunidade) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();
			session.delete(comunidade);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao deletar comunidade: " + e.getMessage());
		}
	}

	public void atualizar(Comunidade comunidade) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();
			session.update(comunidade);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao atualizar comunidade: " + e.getMessage());
		}
	}

	public List<Comunidade> recuperarComunidadesPorIdModerador(Long id) {
		Session session = null;
		List<Comunidade> comunidade = null;

		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();

			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Comunidade> criteriaQuery = criteriaBuilder.createQuery(Comunidade.class);
			Root<Comunidade> raizComunidade = criteriaQuery.from(Comunidade.class);

			Join<Comunidade, Moderador> joinModerador = raizComunidade.join(Comunidade_.MODERADORES, JoinType.INNER);

			Predicate predicateComunidadeModerador = criteriaBuilder.equal(joinModerador.get(Moderador_.ID), id);

			criteriaQuery.where(predicateComunidadeModerador);
			comunidade = session.createQuery(criteriaQuery).getResultList();
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return comunidade;
	}
	
	 public Comunidade recuperarRelatosDaComunidade(Long id) {
	    	
		    
	    	Comunidade relatosDaComunidade = null;
	    	Session session = null;
	    	
	    	try {
	        	session = getSessionFactory().openSession();
	            session.beginTransaction();
	            
	    		CriteriaBuilder builder = session.getCriteriaBuilder();
	    		CriteriaQuery<Comunidade> criteriaQuery = builder.createQuery(Comunidade.class);

	    		Root<Comunidade> comunidadeRoot = criteriaQuery.from(Comunidade.class);
	    		comunidadeRoot.fetch("relatos", JoinType.LEFT);

	    		criteriaQuery.select(comunidadeRoot).distinct(true);
	    		criteriaQuery.where(builder.equal(comunidadeRoot.get(Comunidade_.id), id));

	    		relatosDaComunidade = session.createQuery(criteriaQuery).getSingleResult();

		
		    session.getTransaction().commit();
	    
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    	finally {
	    		if (session != null) {
	    			session.close();
	    			}

	    	}
	        return relatosDaComunidade;
	    }

	public List<Comunidade> recuperarComunidadesPorIdUsuario(Long id) {
		Session session = null;
		List<Comunidade> comunidade = null;

		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();

			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Comunidade> criteriaQuery = criteriaBuilder.createQuery(Comunidade.class);
			Root<Comunidade> raizComunidade = criteriaQuery.from(Comunidade.class);

			Join<Comunidade, Usuario> joinUsuario = raizComunidade.join(Comunidade_.USUARIOS, JoinType.INNER);

			Predicate predicateComunidadeUsuario = criteriaBuilder.equal(joinUsuario.get(Usuario_.ID), id);

			criteriaQuery.where(predicateComunidadeUsuario);
			comunidade = session.createQuery(criteriaQuery).getResultList();
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return comunidade;
	}

	public Comunidade recuperarComunidadePorId(Long id) {
		Comunidade comunidade = null;
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Comunidade> criteria = builder.createQuery(Comunidade.class);
			Root<Comunidade> root = criteria.from(Comunidade.class);

			criteria.select(root).where(builder.equal(root.get(Comunidade_.ID), id));

			comunidade = session.createQuery(criteria).uniqueResult();

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return comunidade;
	}

	public List<Comunidade> recuperarComunidadesPorUsuario(Usuario usuario) {
		Session session = null;
		List<Comunidade> comunidade = null;
		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();

			CriteriaBuilder construtor = session.getCriteriaBuilder();
			CriteriaQuery<Comunidade> criteria = construtor.createQuery(Comunidade.class);
			Root<Comunidade> raizComunidade = criteria.from(Comunidade.class);
			Join<Comunidade, Usuario> joinUsuario = raizComunidade.join(Comunidade_.USUARIOS);

			ParameterExpression<Usuario> usuariorParam = construtor.parameter(Usuario.class);
			criteria.select(raizComunidade).where(construtor.equal(joinUsuario, usuariorParam));

			comunidade = session.createQuery(criteria).setParameter(usuariorParam, usuario).getResultList();

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return comunidade;
	}

	public List<Comunidade> recuperarComunidadesPorNome(String nome) {
		Session session = null;
		List<Comunidade> comunidade = null;
		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();

			CriteriaBuilder construtor = session.getCriteriaBuilder();
			CriteriaQuery<Comunidade> criteria = construtor.createQuery(Comunidade.class);
			Root<Comunidade> raizComunidade = criteria.from(Comunidade.class);
			ParameterExpression<String> comunidadePorNome = construtor.parameter(String.class, Comunidade_.NOME);

			criteria.select(raizComunidade)
					.where(construtor.equal(raizComunidade.get(Comunidade_.NOME), comunidadePorNome));
			comunidade = session.createQuery(criteria).setParameter(comunidadePorNome, nome).getResultList();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return comunidade;
	}

	public List<Comunidade> recuperarTodasComunidades() {

		Session sessao = null;
		List<Comunidade> comunidades = null;

		try {

			sessao = getSessionFactory().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Comunidade> criteria = construtor.createQuery(Comunidade.class);
			Root<Comunidade> raizComunidade = criteria.from(Comunidade.class);

			criteria.select(raizComunidade);

			comunidades = sessao.createQuery(criteria).getResultList();

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}

		return comunidades;
	}
}
