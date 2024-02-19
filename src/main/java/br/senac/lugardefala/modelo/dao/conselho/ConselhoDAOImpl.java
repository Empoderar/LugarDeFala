
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
		configuration.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.foto.Foto.class);	

		configuration.configure("hibernate.cfg.xml");

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void inserir(Conselho conselho) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();
			session.save(conselho);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deletar(Conselho conselho) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();
			session.delete(conselho);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Conselho conselho) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();
			session.update(conselho);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Conselho> recuperarConselhosPorRelato(Relato relato) {
		Session session = null;
		List<Conselho> conselho = null;
		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();

			CriteriaBuilder construtor = session.getCriteriaBuilder();
			CriteriaQuery<Conselho> criteria = construtor.createQuery(Conselho.class);
			Root<Conselho> raizConselho = criteria.from(Conselho.class);
			
			criteria.select(raizConselho).where(construtor.equal(raizConselho.get(Conselho_.RELATO), relato));
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

	public Conselho recuperarConselhoPorId(Long id) {
		Session session = null;
		Conselho conselhosPeloId = null;
		try {
        	session = getSessionFactory().openSession();
            session.beginTransaction();
            
            CriteriaBuilder construtor = session.getCriteriaBuilder();
            CriteriaQuery<Conselho> criteria = construtor.createQuery(Conselho.class);
            Root<Conselho> raizConselho = criteria.from(Conselho.class);
            
            criteria.select(raizConselho).where(construtor.equal(raizConselho.get(Conselho_.ID), id));
            
            ParameterExpression<Long> conselhoPorId = construtor.parameter(Long.TYPE);
			criteria.where(construtor.equal(raizConselho.get(Conselho_.ID), conselhoPorId));
            
			conselhosPeloId = session.createQuery(criteria).setParameter(conselhoPorId, id).getSingleResult();
            
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
        return conselhosPeloId;
    }
	
	public List<Conselho> recuperarConselhosPorUsuario(Usuario usuario) {
		Session session = null;
		List<Conselho> conselhos = null;
		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();

			CriteriaBuilder criteriaConstrutor = session.getCriteriaBuilder();
			CriteriaQuery<Conselho> criteriaConsulta = criteriaConstrutor.createQuery(Conselho.class);
			Root<Conselho> raizUsuario = criteriaConsulta.from(Conselho.class);

			Predicate predicateConselhoUsuario
			= criteriaConstrutor.equal(raizUsuario.get(Conselho_.USUARIO), usuario);

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