package br.senac.lugardefala.modelo.dao.relato;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import br.senac.lugardefala.modelo.entidade.categoria.Categoria;
import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.relato.Relato;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;
import br.senac.lugardefala.modelo.enumeracao.Status;

public class RelatoDAOImpl implements RelatoDAO {

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

    public void inserirRelato(Relato relato) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(relato);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletarRelato(Relato relato) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(relato);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void atualizarRelato(Relato relato) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(relato);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Relato> recuperarRelato() {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            CriteriaBuilder construtor = session.getCriteriaBuilder();
            CriteriaQuery<Relato> criteria = construtor.createQuery(Relato.class);
            Root<Relato> raizRelato = criteria.from(Relato.class);
            criteria.select(raizRelato);
            List<Relato> relatos = session.createQuery(criteria).getResultList();
            session.getTransaction().commit();
            return relatos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Relato recuperarRelatoUsuario(Usuario usuario) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            CriteriaBuilder construtor = session.getCriteriaBuilder();
            CriteriaQuery<Relato> criteria = construtor.createQuery(Relato.class);
            Root<Relato> raizRelato = criteria.from(Relato.class);
            criteria.select(raizRelato).where(construtor.equal(raizRelato.get("usuario"), usuario));
            Relato relato = session.createQuery(criteria).uniqueResult();
            session.getTransaction().commit();
            return relato;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Relato recuperarRelatoStatus(Status status) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            CriteriaBuilder construtor = session.getCriteriaBuilder();
            CriteriaQuery<Relato> criteria = construtor.createQuery(Relato.class);
            Root<Relato> raizRelato = criteria.from(Relato.class);
            criteria.select(raizRelato).where(construtor.equal(raizRelato.get("status"), status));
            Relato relato = session.createQuery(criteria).uniqueResult();
            session.getTransaction().commit();
            return relato;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Relato recuperarRelatoComunidade(Comunidade comunidade) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            CriteriaBuilder construtor = session.getCriteriaBuilder();
            CriteriaQuery<Relato> criteria = construtor.createQuery(Relato.class);
            Root<Relato> raizRelato = criteria.from(Relato.class);
            criteria.select(raizRelato).where(construtor.equal(raizRelato.get("comunidade"), comunidade));
            Relato relato = session.createQuery(criteria).uniqueResult();
            session.getTransaction().commit();
            return relato;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Relato recuperarRelatoCategoria(Categoria categoria) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            CriteriaBuilder construtor = session.getCriteriaBuilder();
            CriteriaQuery<Relato> criteria = construtor.createQuery(Relato.class);
            Root<Relato> raizRelato = criteria.from(Relato.class);
            criteria.select(raizRelato).where(construtor.equal(raizRelato.get("categoria"), categoria));
            Relato relato = session.createQuery(criteria).uniqueResult();
            session.getTransaction().commit();
            return relato;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Relato buscarRelatoPorId(Long id) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            return session.get(Relato.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}