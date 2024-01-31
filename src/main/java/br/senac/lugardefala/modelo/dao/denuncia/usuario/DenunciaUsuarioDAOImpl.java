package br.senac.lugardefala.modelo.dao.denuncia.usuario;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import br.senac.lugardefala.modelo.entidade.denuncia.DenunciaUsuario;
import br.senac.lugardefala.modelo.entidade.denuncia.DenunciaUsuario_;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;
import br.senac.lugardefala.modelo.enumeracao.Status;

public class DenunciaUsuarioDAOImpl implements DenunciaUsuarioDAO {

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

    public void inserirDenunciaUsuario(DenunciaUsuario denunciaUsuario) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(denunciaUsuario);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletarDenunciaUsuario(DenunciaUsuario denunciaUsuario) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(denunciaUsuario);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<DenunciaUsuario> recuperarDenunciaUsuarioStatus(Status status) {
		Session session = null;
		List<DenunciaUsuario> denunciasUsuarios = null;
		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();

			CriteriaBuilder criteriaConstrutor = session.getCriteriaBuilder();
			CriteriaQuery<DenunciaUsuario> criteriaConsulta = criteriaConstrutor.createQuery(DenunciaUsuario.class);
			Root<DenunciaUsuario> raizDenunciaUsuario = criteriaConsulta.from(DenunciaUsuario.class);


			Predicate predicateDenunciaUsuarioStatus
			= criteriaConstrutor.equal(raizDenunciaUsuario.get(DenunciaUsuario_.status), status);

			criteriaConsulta.where(predicateDenunciaUsuarioStatus);
			denunciasUsuarios = session.createQuery(criteriaConsulta).getResultList();
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return denunciasUsuarios;
	}

    public List<DenunciaUsuario> recuperarDenunciaUsuarioPeloUsuario(Usuario usuario) {
		Session session = null;
		List<DenunciaUsuario> denunciasUsuarios = null;
		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();

			CriteriaBuilder criteriaConstrutor = session.getCriteriaBuilder();
			CriteriaQuery<DenunciaUsuario> criteriaConsulta = criteriaConstrutor.createQuery(DenunciaUsuario.class);
			Root<DenunciaUsuario> raizDenunciaUsuario = criteriaConsulta.from(DenunciaUsuario.class);


			Predicate predicateDenunciaUsuarioPeloUsuario
			= criteriaConstrutor.equal(raizDenunciaUsuario.get(DenunciaUsuario_.usuario), usuario);

			criteriaConsulta.where(predicateDenunciaUsuarioPeloUsuario);
			denunciasUsuarios = session.createQuery(criteriaConsulta).getResultList();
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return denunciasUsuarios;
	}

}
