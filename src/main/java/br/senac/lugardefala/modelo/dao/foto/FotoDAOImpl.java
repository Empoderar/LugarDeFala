package br.senac.lugardefala.modelo.dao.foto;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import br.senac.lugardefala.modelo.entidade.foto.Foto;
import br.senac.lugardefala.modelo.entidade.foto.Foto_;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;

public class FotoDAOImpl {

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

    public void inserir(Foto foto) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(foto);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletar(Foto foto) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(foto);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao deletar foto: " + e.getMessage());
        }
    }

    public void atualizar(Foto foto) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(foto);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao atualizar foto: " + e.getMessage());
        }
    }

    public List<Foto> recuperarPorUsuario(Usuario usuario) {
        List<Foto> fotos = null;
        Session session = null;

        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();

            CriteriaBuilder construtor = session.getCriteriaBuilder();
            CriteriaQuery<Foto> criteria = construtor.createQuery(Foto.class);
            Root<Foto> raizFoto = criteria.from(Foto.class);

            ParameterExpression<Usuario> usuarioParam = construtor.parameter(Usuario.class);
            criteria.select(raizFoto).where(construtor.equal(raizFoto.get(Foto_.USUARIO), usuarioParam));

            fotos = session.createQuery(criteria).setParameter(usuarioParam, usuario).getResultList();

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return fotos;
    }

    public Foto recuperarPorId(int id) {
        Session session = null;
        Foto foto = null;

        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();

            CriteriaBuilder construtor = session.getCriteriaBuilder();
            CriteriaQuery<Foto> criteria = construtor.createQuery(Foto.class);
            Root<Foto> raizFoto = criteria.from(Foto.class);

            criteria.where(construtor.equal(raizFoto.get(Foto_.ID), id));

            foto = session.createQuery(criteria).getSingleResult();

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return foto;
    }
}
