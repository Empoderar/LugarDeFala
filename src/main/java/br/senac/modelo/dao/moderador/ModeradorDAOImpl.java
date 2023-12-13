package br.senac.modelo.dao.moderador;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import br.senac.modelo.entidade.moderador.Moderador;

public abstract class ModeradorDAOImpl implements ModeradorDAO {

    public void inserirModerador(Moderador moderador) {
        Session sessao = null;

        try {
            sessao = conectarBanco().openSession();
            sessao.beginTransaction();
            sessao.save(moderador);
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

    public void deletarModerador(Moderador moderador) {
        Session sessao = null;

        try {
            sessao = conectarBanco().openSession();
            sessao.beginTransaction();
            sessao.delete(moderador);
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

    public void atualizarModerador(Moderador moderador) {
        Session sessao = null;

        try {
            sessao = conectarBanco().openSession();
            sessao.beginTransaction();
            sessao.update(moderador);
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

    public List<Moderador> recuperarModeradores() {
        Session sessao = null;
        List<Moderador> moderadores = null;

        try {
            sessao = conectarBanco().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Moderador> criteria = construtor.createQuery(Moderador.class);
            Root<Moderador> raizModerador = criteria.from(Moderador.class);
            criteria.select(raizModerador);
            moderadores = sessao.createQuery(criteria).getResultList();
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

        return moderadores;
    }

    private SessionFactory conectarBanco() {
        Configuration configuracao = new Configuration();
        configuracao.addAnnotatedClass(br.senac.modelo.entidade.moderador.Moderador.class);
        configuracao.addAnnotatedClass(br.senac.modelo.entidade.usuario.Usuario.class);
        configuracao.addAnnotatedClass(br.senac.modelo.entidade.contato.Contato.class);
        configuracao.configure("hibernate.cfg.xml");

        ServiceRegistry servico = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
        SessionFactory fabricaSessao = configuracao.buildSessionFactory(servico);

        return fabricaSessao;
    }
}
