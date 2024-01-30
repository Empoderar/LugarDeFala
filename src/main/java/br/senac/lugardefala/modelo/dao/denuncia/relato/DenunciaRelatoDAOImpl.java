package br.senac.lugardefala.modelo.dao.denuncia.relato;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import br.senac.lugardefala.modelo.entidade.denuncia.DenunciaRelato;
import br.senac.lugardefala.modelo.entidade.relato.Relato;
import br.senac.lugardefala.modelo.enumeracao.Status;

public class DenunciaRelatoDAOImpl implements DenunciaRelatoDAO {

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

    public void inserirDenunciaRelato(DenunciaRelato denunciaRelato) {
        try (Session session = getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(denunciaRelato);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletarDenunciaRelato(DenunciaRelato denunciaRelato) {
        try (Session session = getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(denunciaRelato);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void atualizarDenunciaRelato(DenunciaRelato denunciaRelato) {
        try (Session session = getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(denunciaRelato);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DenunciaRelato recuperarDenunciaDeRelatoStatus(Relato relato, Status status) {
        DenunciaRelato denunciaRelato = null;
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            CriteriaBuilder construtor = session.getCriteriaBuilder();
            CriteriaQuery<DenunciaRelato> criteria = construtor.createQuery(DenunciaRelato.class);
            Root<DenunciaRelato> raizDenuncia = criteria.from(DenunciaRelato.class);
            criteria.select(raizDenuncia).where(
                    construtor.equal(raizDenuncia.get("relato"), relato),
                    construtor.equal(raizDenuncia.get("status"), status));
            denunciaRelato = session.createQuery(criteria).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return denunciaRelato;
    }

    public DenunciaRelato recuperarDenunciaDeRelatoRelato(Relato relato) {
        DenunciaRelato denunciaRelato = null;
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            CriteriaBuilder construtor = session.getCriteriaBuilder();
            CriteriaQuery<DenunciaRelato> criteria = construtor.createQuery(DenunciaRelato.class);
            Root<DenunciaRelato> raizDenuncia = criteria.from(DenunciaRelato.class);
            criteria.select(raizDenuncia).where(construtor.equal(raizDenuncia.get("relato"), relato));
            denunciaRelato = session.createQuery(criteria).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return denunciaRelato;
    }


}
