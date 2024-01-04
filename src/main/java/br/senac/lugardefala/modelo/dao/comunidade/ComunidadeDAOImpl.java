package br.senac.lugardefala.modelo.dao.comunidade;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.moderador.Moderador;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;

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
			e.printStackTrace();
		}
	}

	public void deletarComunidade(Comunidade comunidade) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();
			session.delete(comunidade);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Comunidade recuperarComunidadeModerador(Moderador moderador) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();

			CriteriaBuilder construtor = session.getCriteriaBuilder();
			CriteriaQuery<Comunidade> criteria = construtor.createQuery(Comunidade.class);
			Root<Comunidade> raizComunidade = criteria.from(Comunidade.class);

			criteria.select(raizComunidade).where(construtor.equal(raizComunidade.get("moderador"), moderador));
			Comunidade comunidade = session.createQuery(criteria).uniqueResult();
			session.getTransaction().commit();

			return comunidade;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Comunidade recuperarComunidadeUsuario(Usuario usuario) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();

			CriteriaBuilder construtor = session.getCriteriaBuilder();
			CriteriaQuery<Comunidade> criteria = construtor.createQuery(Comunidade.class);
			Root<Comunidade> raizComunidade = criteria.from(Comunidade.class);

			criteria.select(raizComunidade).where(construtor.equal(raizComunidade.get("usuario"), usuario));
			Comunidade comunidade = session.createQuery(criteria).uniqueResult();
			session.getTransaction().commit();

			return comunidade;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Comunidade recuperarComunidadeNome(String nome) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();

			CriteriaBuilder construtor = session.getCriteriaBuilder();
			CriteriaQuery<Comunidade> criteria = construtor.createQuery(Comunidade.class);
			Root<Comunidade> raizComunidade = criteria.from(Comunidade.class);

			criteria.select(raizComunidade).where(construtor.equal(raizComunidade.get("nome"), nome));
			Comunidade comunidade = session.createQuery(criteria).uniqueResult();
			session.getTransaction().commit();

			return comunidade;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
