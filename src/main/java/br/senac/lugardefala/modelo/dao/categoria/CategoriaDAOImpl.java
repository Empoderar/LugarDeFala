package br.senac.lugardefala.modelo.dao.categoria;

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

import br.senac.lugardefala.modelo.entidade.categoria.Categoria;
import br.senac.lugardefala.modelo.entidade.categoria.Categoria_;
import br.senac.lugardefala.modelo.entidade.relato.Relato;

public class CategoriaDAOImpl implements CategoriaDAO {

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

	public void inserirCategoria(Categoria categoria) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();
			session.save(categoria);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deletarCategoria(Categoria categoria) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();
			session.delete(categoria);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void atualizarCategoria(Categoria categoria) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();
			session.update(categoria);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Categoria> recuperarCategoria(String nome) {
    	
		List<Categoria> categoriaRecuperada = null;
    	Session session = null;
    	  
    	try {
        	session = getSessionFactory().openSession();
            session.beginTransaction();
            
            CriteriaBuilder construtor = session.getCriteriaBuilder();
            CriteriaQuery<Categoria> criteria = construtor.createQuery(Categoria.class);
            Root<Categoria> raizRelato = criteria.from(Categoria.class);
            
            criteria.select(raizRelato).where(construtor.equal(raizRelato.get(Categoria_.nome), nome));
            
            ParameterExpression<Categoria> relatoCategoria = construtor.parameter(Categoria.class);
			criteria.where(construtor.equal(raizRelato.get(Categoria_.nome), relatoCategoria));
            
			categoriaRecuperada = session.createQuery(criteria).getResultList();
            
            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    	finally {
    		if (session != null) {
    			session.close();
    			}

    	}
        return categoriaRecuperada;
    }
   

	public Categoria recuperarCategoriaPeloId(Long id) {
	    Categoria categoria = null;
	    Session session = null;

	    try {
	        session = getSessionFactory().openSession();
	        session.beginTransaction();

	        CriteriaBuilder builder = session.getCriteriaBuilder();
	        CriteriaQuery<Categoria> criteria = builder.createQuery(Categoria.class);
	        Root<Categoria> root = criteria.from(Categoria.class);

	        criteria.select(root).where(builder.equal(root.get(Categoria_.id), id));

	        categoria = session.createQuery(criteria).uniqueResult();

	        session.getTransaction().commit();

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	    return categoria;
	}

	public Categoria recuperarCategoriaRelato(Relato relato) {
	    Categoria categoria = null;
	    Session session = null;

	    try {
	        session = getSessionFactory().openSession();
	        session.beginTransaction();

	        CriteriaBuilder builder = session.getCriteriaBuilder();
	        CriteriaQuery<Categoria> criteria = builder.createQuery(Categoria.class);
	        Root<Categoria> root = criteria.from(Categoria.class);

	        criteria.select(root).where(builder.isMember(relato, root.get(Categoria_.relatos)));

	        categoria = session.createQuery(criteria).uniqueResult();

	        session.getTransaction().commit();

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	    return categoria;
	}

}
