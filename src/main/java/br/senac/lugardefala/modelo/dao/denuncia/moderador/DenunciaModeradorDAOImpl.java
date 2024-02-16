package br.senac.lugardefala.modelo.dao.denuncia.moderador;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import br.senac.lugardefala.modelo.entidade.denuncia.DenunciaModerador;

public class DenunciaModeradorDAOImpl implements DenunciaModeradorDAO {

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

    public void inserirDenunciaModerador(DenunciaModerador denunciaModerador) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(denunciaModerador);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletarDenunciaModerador(DenunciaModerador denunciaModerador) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(denunciaModerador);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DenunciaModerador recuperarDenunciaModeradorPorId(long id) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            return session.get(DenunciaModerador.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
