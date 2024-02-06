package br.senac.lugardefala.modelo.dao.denuncia.usuario;

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

import br.senac.lugardefala.modelo.entidade.denuncia.DenunciaUsuario;
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
        List<DenunciaUsuario> denunciaUsuario = null;
        Session session = null;

        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();

            CriteriaBuilder construtor = session.getCriteriaBuilder();
            CriteriaQuery<DenunciaUsuario> criteria = construtor.createQuery(DenunciaUsuario.class);
            Root<DenunciaUsuario> raizDenuncia = criteria.from(DenunciaUsuario.class);

            ParameterExpression<Status> statusParam = construtor.parameter(Status.class);
            criteria.select(raizDenuncia).where(construtor.equal(raizDenuncia.get("status"), statusParam));

            denunciaUsuario = session.createQuery(criteria).setParameter(statusParam, status).getResultList();

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return denunciaUsuario;
    }



    public List<DenunciaUsuario> recuperarDenunciaUsuarioPeloUsuario(Usuario usuario) {
    	    List<DenunciaUsuario> denunciaUsuario = null;
    	    Session session = null;

    	    try {
    	        session = getSessionFactory().openSession();
    	        session.beginTransaction();

    	        CriteriaBuilder construtor = session.getCriteriaBuilder();
    	        CriteriaQuery<DenunciaUsuario> criteria = construtor.createQuery(DenunciaUsuario.class);
    	        Root<DenunciaUsuario> raizDenuncia = criteria.from(DenunciaUsuario.class);
    	        Join<DenunciaUsuario, Usuario> joinUsuario = raizDenuncia.join("usuario");

    	        ParameterExpression<Usuario> usuarioParam = construtor.parameter(Usuario.class);
    	        criteria.select(raizDenuncia).where(construtor.equal(joinUsuario, usuarioParam));

    	        denunciaUsuario = session.createQuery(criteria).setParameter(usuarioParam, usuario).getResultList();

    	        session.getTransaction().commit();

    	    } catch (Exception e) {
    	        e.printStackTrace();
    	    } finally {
    	        if (session != null) {
    	            session.close();
    	        }
    	    }
    	    return denunciaUsuario;
    	}

}
