package br.senac.lugardefala.modelo.dao.denuncia.conselho;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import br.senac.lugardefala.modelo.entidade.conselho.Conselho;
import br.senac.lugardefala.modelo.entidade.denuncia.Denuncia;
import br.senac.lugardefala.modelo.entidade.relato.Relato;
import br.senac.lugardefala.modelo.enumeracao.Status;

public class DenunciaConselhoDAOImpl implements DenunciaConselhoDAO {

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

    public void inserirDenunciaConselho(Denuncia denuncia) {
        try (Session session = getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(denuncia);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletarDenunciaConselho(Denuncia denuncia) {
        try (Session session = getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(denuncia);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Denuncia recuperarDenunciaDeConselhoStatus(Conselho conselho, Status status) {
        Denuncia denuncia = null;
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            CriteriaBuilder construtor = session.getCriteriaBuilder();
            CriteriaQuery<Denuncia> criteria = construtor.createQuery(Denuncia.class);
            Root<Denuncia> raizDenuncia = criteria.from(Denuncia.class);
            criteria.select(raizDenuncia).where(
                    construtor.equal(raizDenuncia.get("conselho"), conselho),
                    construtor.equal(raizDenuncia.get("status"), status));
            denuncia = session.createQuery(criteria).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return denuncia;
    }

    public Denuncia recuperarDenunciaDeConselhoRelato(Conselho conselho, Relato relato) {
        Denuncia denuncia = null;
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            CriteriaBuilder construtor = session.getCriteriaBuilder();
            CriteriaQuery<Denuncia> criteria = construtor.createQuery(Denuncia.class);
            Root<Denuncia> raizDenuncia = criteria.from(Denuncia.class);
            criteria.select(raizDenuncia).where(
                    construtor.equal(raizDenuncia.get("conselho"), conselho),
                    construtor.equal(raizDenuncia.get("relato"), relato));
            denuncia = session.createQuery(criteria).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return denuncia;
    }

}
