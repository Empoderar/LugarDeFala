package br.senac.lugardefala.modelo.dao.categoria;

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
		configuration.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.foto.Foto.class);	

		configuration.configure("hibernate.cfg.xml");

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void inserir(Categoria categoria) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();
			session.save(categoria);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deletar(Categoria categoria) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();
			session.delete(categoria);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Categoria categoria) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();
			session.update(categoria);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Categoria> recuperarTodos() {
    	
		List<Categoria> categoriaRecuperada = null;
    	Session sessao = null; 	  
    	try {
            sessao = getSessionFactory().openSession();
            sessao.beginTransaction();

            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Categoria> criteria = construtor.createQuery(Categoria.class);
            Root<Categoria> raizCategoria = criteria.from(Categoria.class);

            criteria.select(raizCategoria);

            categoriaRecuperada = sessao.createQuery(criteria).getResultList();

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
        return categoriaRecuperada;
    }

	public Categoria recuperarPorId(Long id) {
	    Categoria categoria = null;
	    Session session = null;

	    try {
	        session = getSessionFactory().openSession();
	        session.beginTransaction();

	        CriteriaBuilder builder = session.getCriteriaBuilder();
	        CriteriaQuery<Categoria> criteria = builder.createQuery(Categoria.class);
	        Root<Categoria> root = criteria.from(Categoria.class);

	        criteria.select(root).where(builder.equal(root.get(Categoria_.ID), id));

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

	public List <Categoria> recuperarPorRelato(Relato relato) {
	    List <Categoria> categoria = null;
	    Session session = null;

	    try {
	        session = getSessionFactory().openSession();
	        session.beginTransaction();

	        CriteriaBuilder builder = session.getCriteriaBuilder();
	        CriteriaQuery<Categoria> criteria = builder.createQuery(Categoria.class);
	        Root<Categoria> root = criteria.from(Categoria.class);

	        criteria.select(root).where(builder.isMember(relato, root.get(Categoria_.RELATOS)));

	        categoria = session.createQuery(criteria).getResultList();

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
	
	public 	Categoria recuperarPorNome(String nome){
	    Categoria categoria = null;
	    Session session = null;

	    try {
	        session = getSessionFactory().openSession();
	        session.beginTransaction();

	        CriteriaBuilder builder = session.getCriteriaBuilder();
	        CriteriaQuery<Categoria> criteria = builder.createQuery(Categoria.class);
	        Root<Categoria> root = criteria.from(Categoria.class);

	        criteria.select(root).where(builder.equal(root.get(Categoria_.NOME), nome));

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
