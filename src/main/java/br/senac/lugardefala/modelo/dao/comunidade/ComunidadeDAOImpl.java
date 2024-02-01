package br.senac.lugardefala.modelo.dao.comunidade;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;

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

		configuration.configure("hibernate.cfg.xml");

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void inserirComunidade(Comunidade comunidade) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();
			session.save(comunidade);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao inserir comunidade: " + e.getMessage());
		}
	}

	public void deletarComunidade(Comunidade comunidade) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();
			session.delete(comunidade);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao deletar comunidade: " + e.getMessage());
		}
	}
	
	public void atualizarComunidade(Comunidade comunidade) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();
			session.update(comunidade);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao atualizar comunidade: " + e.getMessage());
		}
	}


	public List <Comunidade> recuperarComunidadesPeloIdModerador(Long id){
	    List <Comunidade> comunidade = null;
	    Session session = null;
	    try {
	        session = getSessionFactory().openSession();
	        session.beginTransaction();

	        CriteriaBuilder construtor = session.getCriteriaBuilder();
	        CriteriaQuery<Comunidade> criteria = construtor.createQuery(Comunidade.class);
	        Root<Comunidade> raizComunidade = criteria.from(Comunidade.class);

	        criteria.select(raizComunidade).where(construtor.equal(raizComunidade.get("id"), id));
	        comunidade = session.createQuery(criteria).getResultList();

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

	public List <Comunidade> recuperarComunidadesPeloIdUsuario(Long id) {
		List <Comunidade> comunidade = null;
	    Session session = null;
	    try {
	        session = getSessionFactory().openSession();
	        session.beginTransaction();

	        CriteriaBuilder construtor = session.getCriteriaBuilder();
	        CriteriaQuery<Comunidade> criteria = construtor.createQuery(Comunidade.class);
	        Root<Comunidade> raizComunidade = criteria.from(Comunidade.class);

	        criteria.select(raizComunidade).where(construtor.equal(raizComunidade.get("id"), id));
	        comunidade = session.createQuery(criteria).getResultList();

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

	public Comunidade recuperarComunidadePeloId(Long id) {
	    Comunidade comunidade = null;
	    Session session = null;
	    try {
	        session = getSessionFactory().openSession();
	        session.beginTransaction();

	        CriteriaBuilder construtor = session.getCriteriaBuilder();
	        CriteriaQuery<Comunidade> criteria = construtor.createQuery(Comunidade.class);
	        Root<Comunidade> raizComunidade = criteria.from(Comunidade.class);

	        criteria.select(raizComunidade).where(construtor.equal(raizComunidade.get("id"), id));
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


}
