package br.senac.lugardefala.modelo.dao.denuncia;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import br.senac.lugardefala.modelo.entidade.conselho.Conselho;
import br.senac.lugardefala.modelo.entidade.denuncia.Denuncia;
import br.senac.lugardefala.modelo.entidade.denuncia.DenunciaConselho;
import br.senac.lugardefala.modelo.entidade.denuncia.DenunciaModerador;
import br.senac.lugardefala.modelo.entidade.denuncia.DenunciaRelato;
import br.senac.lugardefala.modelo.entidade.denuncia.DenunciaUsuario;
import br.senac.lugardefala.modelo.entidade.relato.Relato;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;
import br.senac.lugardefala.modelo.enumeracao.Status;

public class DenunciaDAOImpl implements DenunciaDAO {

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

    
    public void inserirDenuncia(Denuncia denuncia) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(denuncia);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public void inserirDenunciaModerador(DenunciaModerador denunciaModerador) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(denunciaModerador);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public void inserirDenunciaRelato(DenunciaRelato denunciaRelato) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(denunciaRelato);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void inserirDenunciaConselho(DenunciaConselho denunciaConselho) {
    	try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(denunciaConselho);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    
    public void deletarDenuncia(Denuncia denuncia) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(denuncia);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public void atualizarDenuncia(Denuncia denuncia) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(denuncia);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public Denuncia recuperarDenunciaUsuario(Usuario usuario) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            CriteriaBuilder construtor = session.getCriteriaBuilder();
            CriteriaQuery<Denuncia> criteria = construtor.createQuery(Denuncia.class);
            Root<Denuncia> raizDenuncia = criteria.from(Denuncia.class);
            criteria.select(raizDenuncia).where(construtor.equal(raizDenuncia.get("usuario"), usuario));
            Denuncia denuncia = session.createQuery(criteria).uniqueResult();
            session.getTransaction().commit();
            return denuncia;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
    public Denuncia recuperarDenunciaDeRelatoStatus(Relato relato, Status status) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            CriteriaBuilder construtor = session.getCriteriaBuilder();
            CriteriaQuery<DenunciaRelato> criteria = construtor.createQuery(DenunciaRelato.class);
            Root<DenunciaRelato> raizDenuncia = criteria.from(DenunciaRelato.class);
            criteria.select(raizDenuncia).where(
                    construtor.equal(raizDenuncia.get("relato"), relato),
                    construtor.equal(raizDenuncia.get("status"), status));
            DenunciaRelato denuncia = session.createQuery(criteria).uniqueResult();
            session.getTransaction().commit();
            return denuncia;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
    public Denuncia recuperarDenunciaDeRelatoRelato(Relato relato) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            CriteriaBuilder construtor = session.getCriteriaBuilder();
            CriteriaQuery<Denuncia> criteria = construtor.createQuery(Denuncia.class);
            Root<Denuncia> raizDenuncia = criteria.from(Denuncia.class);
            criteria.select(raizDenuncia).where(construtor.equal(raizDenuncia.get("relato"), relato));
            Denuncia denuncia = session.createQuery(criteria).uniqueResult();
            session.getTransaction().commit();
            return denuncia;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
    public Denuncia recuperarDenunciaDeConselhoStatus(Conselho conselho, Status status) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            CriteriaBuilder construtor = session.getCriteriaBuilder();
            CriteriaQuery<Denuncia> criteria = construtor.createQuery(Denuncia.class);
            Root<Denuncia> raizDenuncia = criteria.from(Denuncia.class);
            criteria.select(raizDenuncia).where(
                    construtor.equal(raizDenuncia.get("conselho"), conselho),
                    construtor.equal(raizDenuncia.get("status"), status));
            Denuncia denuncia = session.createQuery(criteria).uniqueResult();
            session.getTransaction().commit();
            return denuncia;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
    public Denuncia recuperarDenunciaDeConselhoRelato(Conselho conselho, Relato relato) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            CriteriaBuilder construtor = session.getCriteriaBuilder();
            CriteriaQuery<Denuncia> criteria = construtor.createQuery(Denuncia.class);
            Root<Denuncia> raizDenuncia = criteria.from(Denuncia.class);
            criteria.select(raizDenuncia).where(
                    construtor.equal(raizDenuncia.get("conselho"), conselho),
                    construtor.equal(raizDenuncia.get("relato"), relato));
            Denuncia denuncia = session.createQuery(criteria).uniqueResult();
            session.getTransaction().commit();
            return denuncia;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
    public Denuncia recuperarDenunciaDeUsuarioStatus(Usuario usuario, Status status) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            CriteriaBuilder construtor = session.getCriteriaBuilder();
            CriteriaQuery<DenunciaUsuario> criteria = construtor.createQuery(DenunciaUsuario.class);
            Root<DenunciaUsuario> raizDenuncia = criteria.from(DenunciaUsuario.class);
            criteria.select(raizDenuncia).where(
                    construtor.equal(raizDenuncia.get("usuario"), usuario),
                    construtor.equal(raizDenuncia.get("status"), status));
            DenunciaUsuario denuncia = session.createQuery(criteria).uniqueResult();
            session.getTransaction().commit();
            return denuncia;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
    public Denuncia recuperarDenunciaDeUsuarioUsuario(Usuario usuario) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            CriteriaBuilder construtor = session.getCriteriaBuilder();
            CriteriaQuery<Denuncia> criteria = construtor.createQuery(Denuncia.class);
            Root<Denuncia> raizDenuncia = criteria.from(Denuncia.class);
            criteria.select(raizDenuncia).where(construtor.equal(raizDenuncia.get("usuario"), usuario));
            Denuncia denuncia = session.createQuery(criteria).uniqueResult();
            session.getTransaction().commit();
            return denuncia;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
