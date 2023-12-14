package br.senac.lugardefala.modelo.dao.status;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import br.senac.lugardefala.modelo.entidade.status.Status;

public class StatusDAOImpl implements StatusDAO {

    public void inserirStatus(Status status) {
        Session sessao = null;

        try {
            sessao = conectarBanco().openSession();
            sessao.beginTransaction();
            sessao.save(status);
            sessao.getTransaction().commit();

        } catch (Exception sqlException) {
            sqlException.printStackTrace();

            if (sessao.getTransaction() != null) {
                sessao.getTransaction().rollback();
            }

        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
    }

    public void deletarStatus(Status status) {
        Session sessao = null;

        try {
            sessao = conectarBanco().openSession();
            sessao.beginTransaction();
            sessao.delete(status);
            sessao.getTransaction().commit();

        } catch (Exception sqlException) {
            sqlException.printStackTrace();

            if (sessao.getTransaction() != null) {
                sessao.getTransaction().rollback();
            }

        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
    }

    public void atualizarStatus(Status status) {
        Session sessao = null;

        try {
            sessao = conectarBanco().openSession();
            sessao.beginTransaction();
            sessao.update(status);
            sessao.getTransaction().commit();

        } catch (Exception sqlException) {
            sqlException.printStackTrace();

            if (sessao.getTransaction() != null) {
                sessao.getTransaction().rollback();
            }

        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
    }

    public List<Status> recuperarStatus() {
        Session sessao = null;
        List<Status> statusList = null;

        try {
            sessao = conectarBanco().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Status> criteria = construtor.createQuery(Status.class);
            Root<Status> raizStatus = criteria.from(Status.class);
            criteria.select(raizStatus);
            statusList = sessao.createQuery(criteria).getResultList();
            sessao.getTransaction().commit();

        } catch (Exception sqlException) {
            sqlException.printStackTrace();

            if (sessao.getTransaction() != null) {
                sessao.getTransaction().rollback();
            }

        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }

        return statusList;
    }

    private SessionFactory conectarBanco() {
        Configuration configuracao = new Configuration();
        configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.status.Status.class);
        configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.relato.Relato.class);
        configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.denuncia.Denuncia.class);

        configuracao.configure("hibernate.cfg.xml");

        ServiceRegistry servico = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
        SessionFactory fabricaSessao = configuracao.buildSessionFactory(servico);

        return fabricaSessao;
    }
}
