package br.senac.lugardefala.modelo.dao.moderador;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.moderador.Moderador;
import br.senac.lugardefala.modelo.entidade.moderador.Moderador_;

public class ModeradorDAOImpl implements ModeradorDAO {

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

	public void inserir(Moderador moderador) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();
			session.save(moderador);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deletar(Moderador moderador) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();
			session.delete(moderador);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao deletar moderador: " + e.getMessage());
		}
	}

	public void atualizar(Moderador moderador) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();
			session.update(moderador);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao atualizar moderador: " + e.getMessage());
		}
	}

	public List<Moderador> recuperarPelaComunidade(Comunidade comunidade) {
	    List<Moderador> moderadores = null;
	    Session session = null;

	    try {
	        session = getSessionFactory().openSession();
	        session.beginTransaction();

	        CriteriaBuilder construtor = session.getCriteriaBuilder();
	        CriteriaQuery<Moderador> criteria = construtor.createQuery(Moderador.class);
	        Root<Moderador> raizModerador = criteria.from(Moderador.class);
	        Join<Moderador, Comunidade> joinComunidades = raizModerador.join("comunidades");

	        ParameterExpression<Comunidade> comunidadeParam = construtor.parameter(Comunidade.class);
	        criteria.select(raizModerador).where(construtor.equal(joinComunidades, comunidadeParam));

	        moderadores = session.createQuery(criteria).setParameter(comunidadeParam, comunidade).getResultList();

	        session.getTransaction().commit();

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	    return moderadores;
	}

	public List<Moderador> recuperarPorId(Long id) {
		Session session = null;
		List<Moderador> moderador = new ArrayList<>();

		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();
			CriteriaBuilder construtor = session.getCriteriaBuilder();

			CriteriaQuery<Moderador> criteria = construtor.createQuery(Moderador.class);
			Root<Moderador> raizModerador = criteria.from(Moderador.class);

			criteria.where(construtor.equal(raizModerador.get(Moderador_.id), id));

			moderador = session.createQuery(criteria).getResultList();

			session.getTransaction().commit();

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		} finally {

			if (session != null) {
				session.close();
			}
		}

		return moderador;

	}

	public Moderador recuperarPorNome(String nome) {
		Session session = null;
		Moderador moderadoresPeloNome = null;
		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();
			CriteriaBuilder construtor = session.getCriteriaBuilder();
			CriteriaQuery<Moderador> criteria = construtor.createQuery(Moderador.class);
			Root<Moderador> raizModerador = criteria.from(Moderador.class);
			ParameterExpression<String> moderadorPeloNome = construtor.parameter(String.class, "nome");
			criteria.select(raizModerador).where(construtor.equal(raizModerador.get("nome"), moderadorPeloNome));
			moderadoresPeloNome = session.createQuery(criteria).setParameter(moderadorPeloNome, nome).getSingleResult();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return moderadoresPeloNome;

	}

}