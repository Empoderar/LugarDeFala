
package br.senac.lugardefala.modelo.dao.conselho;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import br.senac.lugardefala.modelo.entidade.conselho.Conselho;
import br.senac.lugardefala.modelo.entidade.conselho.Conselho_;
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

	public List<Conselho> recuperarConselhoRelato(Relato relato) {
		Session session = null;
		List<Conselho> conselho = null;
		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();

			CriteriaBuilder construtor = session.getCriteriaBuilder();
			CriteriaQuery<Conselho> criteria = construtor.createQuery(Conselho.class);
			Root<Conselho> raizConselho = criteria.from(Conselho.class);
			criteria.select(raizConselho).where(construtor.equal(raizConselho.get(Conselho_.relato), relato));
			conselho = session.createQuery(criteria).getResultList();

			session.getTransaction().commit();
			return conselho;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return conselho;
		
	}

	public Conselho recuperarConselhoPeloId(Long id) {
		Session session = null;
		Conselho conselhosPeloId = null;
		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();
			
			CriteriaBuilder construtor = session.getCriteriaBuilder();
			CriteriaQuery<Conselho> criteria = construtor.createQuery(Conselho.class);
			Root<Conselho> raizUsuario = criteria.from(Conselho.class);
			ParameterExpression<Long> conselhoPeloId = construtor.parameter(Long.class, "id");
			
			criteria.select(raizUsuario).where(construtor.equal(raizUsuario.get("id"), conselhoPeloId));
			conselhosPeloId = session.createQuery(criteria).setParameter(conselhoPeloId, id).getSingleResult();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return conselhosPeloId;
	}
	
	public List<Conselho> recuperarConselhoPeloUsuario(Usuario usuario) {
		Session session = null;
		List<Conselho> conselhos = null;
		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();

			CriteriaBuilder criteriaConstrutor = session.getCriteriaBuilder();
			CriteriaQuery<Conselho> criteriaConsulta = criteriaConstrutor.createQuery(Conselho.class);
			Root<Conselho> raizUsuario = criteriaConsulta.from(Conselho.class);

			Predicate predicateConselhoUsuario
			= criteriaConstrutor.equal(raizUsuario.get(Conselho_.usuario), usuario);

			criteriaConsulta.where(predicateConselhoUsuario);
			conselhos = session.createQuery(criteriaConsulta).getResultList();
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return conselhos;
	}
}