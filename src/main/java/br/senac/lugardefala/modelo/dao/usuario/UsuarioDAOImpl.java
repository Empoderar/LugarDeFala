package br.senac.lugardefala.modelo.dao.usuario;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.conselho.Conselho;
import br.senac.lugardefala.modelo.entidade.denuncia.Denuncia;
import br.senac.lugardefala.modelo.entidade.relato.Relato;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {

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

    public void inserirUsuario(Usuario usuario) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(usuario);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletarUsuario(Usuario usuario) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(usuario);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void atualizarUsuario(Usuario usuario) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(usuario);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Usuario recuperarUsuarioNome(String nome) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            CriteriaBuilder construtor = session.getCriteriaBuilder();
            CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
            Root<Usuario> raizUsuario = criteria.from(Usuario.class);
            criteria.select(raizUsuario).where(construtor.equal(raizUsuario.get("nome"), nome));
            Usuario usuario = session.createQuery(criteria).uniqueResult();
            session.getTransaction().commit();
            return usuario;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Usuario recuperarUsuarioComunidade(Comunidade comunidade) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            CriteriaBuilder construtor = session.getCriteriaBuilder();
            CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
            Root<Usuario> raizUsuario = criteria.from(Usuario.class);
            criteria.select(raizUsuario).where(construtor.equal(raizUsuario.get("comunidade"), comunidade));
            Usuario usuario = session.createQuery(criteria).uniqueResult();
            session.getTransaction().commit();
            return usuario;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Usuario recuperarUsuarioConselho(Conselho conselho) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            CriteriaBuilder construtor = session.getCriteriaBuilder();
            CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
            Root<Usuario> raizUsuario = criteria.from(Usuario.class);
            criteria.select(raizUsuario).where(construtor.equal(raizUsuario.get("conselho"), conselho));
            Usuario usuario = session.createQuery(criteria).uniqueResult();
            session.getTransaction().commit();
            return usuario;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Usuario recuperarUsuarioDenuncia(Denuncia denuncia) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            CriteriaBuilder construtor = session.getCriteriaBuilder();
            CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
            Root<Usuario> raizUsuario = criteria.from(Usuario.class);
            criteria.select(raizUsuario).where(construtor.equal(raizUsuario.get("denuncia"), denuncia));
            Usuario usuario = session.createQuery(criteria).uniqueResult();
            session.getTransaction().commit();
            return usuario;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Usuario recuperarUsuarioRelato(Relato relato) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            CriteriaBuilder construtor = session.getCriteriaBuilder();
            CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
            Root<Usuario> raizUsuario = criteria.from(Usuario.class);
            criteria.select(raizUsuario).where(construtor.equal(raizUsuario.get("relato"), relato));
            Usuario usuario = session.createQuery(criteria).uniqueResult();
            session.getTransaction().commit();
            return usuario;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
