package br.senac.lugardefala.modelo.dao.conselho;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import br.senac.lugardefala.modelo.entidade.conselho.Conselho;
import br.senac.lugardefala.modelo.entidade.relato.Relato;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;

public class ConselhoDAOImpl implements ConselhoDAO {

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

	public void inserirConselho(Conselho conselho) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();
			session.save(conselho);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deletarConselho(Conselho conselho) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();
			session.delete(conselho);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void atualizarConselho(Conselho conselho) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();
			session.update(conselho);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Conselho recuperarConselhoUsuario(Usuario usuario) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();

			CriteriaBuilder construtor = session.getCriteriaBuilder();
			CriteriaQuery<Conselho> criteria = construtor.createQuery(Conselho.class);
			Root<Conselho> raizConselho = criteria.from(Conselho.class);

			criteria.select(raizConselho).where(construtor.equal(raizConselho.get("usuario"), usuario));
			Conselho conselho = session.createQuery(criteria).uniqueResult();

			session.getTransaction().commit();

			return conselho;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Conselho recuperarConselhoRelato(Relato relato) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();

			CriteriaBuilder construtor = session.getCriteriaBuilder();
			CriteriaQuery<Conselho> criteria = construtor.createQuery(Conselho.class);
			Root<Conselho> raizConselho = criteria.from(Conselho.class);

			criteria.select(raizConselho).where(construtor.equal(raizConselho.get("relato"), relato));
			Conselho conselho = session.createQuery(criteria).uniqueResult();

			session.getTransaction().commit();

			return conselho;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
