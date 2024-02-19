package br.senac.lugardefala.modelo.dao.contato;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import br.senac.lugardefala.modelo.entidade.contato.Contato;
import br.senac.lugardefala.modelo.entidade.contato.Contato_;

public class ContatoDAOImpl implements ContatoDAO {

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

    public void inserir(Contato contato) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(contato);
            session.getTransaction().commit();
        } catch (Exception e) {
        	System.out.println("Erro ao inserir contato: " + e.getMessage());
        }
    }

    public void atualizar(Contato contato) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(contato);
            session.getTransaction().commit();
        } catch (Exception e) {
        	System.out.println("Erro ao atualizar contato: " + e.getMessage());
        }
    }
    

	public void deletar(Contato contato) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();
			session.delete(contato);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao deletar contato: " + e.getMessage());
		}
	}

	public Contato recuperarContatoPorId(Long id) {
	    Contato contato = null;
	    Session session = null;
	    try {
	        session = getSessionFactory().openSession();
	        session.beginTransaction();

	        CriteriaBuilder construtor = session.getCriteriaBuilder();
	        CriteriaQuery<Contato> criteria = construtor.createQuery(Contato.class);
	        Root<Contato> raizContato = criteria.from(Contato.class);

	        criteria.select(raizContato).where(construtor.equal(raizContato.get(Contato_.ID), id));
	        contato = session.createQuery(criteria).getSingleResult();

	        session.getTransaction().commit();

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	    return contato;
	}


}
