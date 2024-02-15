package br.senac.lugardefala.modelo.dao.relato;

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
import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.relato.Relato;
import br.senac.lugardefala.modelo.entidade.relato.Relato_;
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
        configuration.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.foto.Foto.class);	

        configuration.configure("hibernate.cfg.xml");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    private SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void inserir(Relato relato) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(relato);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletar(Relato relato) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(relato);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Relato relato) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(relato);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Relato> recuperarRelato() {
        List<Relato> relatos = null;
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();

            CriteriaBuilder construtor = session.getCriteriaBuilder();
            CriteriaQuery<Relato> criteria = construtor.createQuery(Relato.class);
            Root<Relato> raizRelato = criteria.from(Relato.class);
            criteria.select(raizRelato);

            relatos = session.createQuery(criteria).getResultList();

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return relatos;
    }


    public List <Relato> recuperarPorUsuario(Usuario usuario) {
    	List<Relato> relatosUsuario = null;
    	Session session = null;
  	  
        try {
        	session = getSessionFactory().openSession();
            session.beginTransaction();
            
            CriteriaBuilder construtor = session.getCriteriaBuilder();
            CriteriaQuery<Relato> criteria = construtor.createQuery(Relato.class);
            Root<Relato> raizRelato = criteria.from(Relato.class);
            
            criteria.select(raizRelato).where(construtor.equal(raizRelato.get(Relato_.USUARIO), usuario));
            
            ParameterExpression<Usuario> relatoUsuario = construtor.parameter(Usuario.class);
			criteria.where(construtor.equal(raizRelato.get(Relato_.USUARIO), relatoUsuario));
            
            relatosUsuario = session.createQuery(criteria).setParameter(relatoUsuario, usuario).getResultList();
            
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
        return relatosUsuario;
    }

    public List<Relato> recuperarPorStatus(Status status) {
    	
    	List<Relato> relatosStatus = null;
    	Session session = null;
    	  
    	try {
        	session = getSessionFactory().openSession();
            session.beginTransaction();
            
            CriteriaBuilder construtor = session.getCriteriaBuilder();
            CriteriaQuery<Relato> criteria = construtor.createQuery(Relato.class);
            Root<Relato> raizRelato = criteria.from(Relato.class);
            
            criteria.select(raizRelato).where(construtor.equal(raizRelato.get(Relato_.STATUS), status));
            
            ParameterExpression<Status> relatoStatus = construtor.parameter(Status.class);
			criteria.where(construtor.equal(raizRelato.get(Relato_.STATUS), relatoStatus));
            
            relatosStatus= session.createQuery(criteria).setParameter(relatoStatus, status).getResultList();
            
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
        return relatosStatus;
    }

    public List <Relato> recuperarPorComunidade(Comunidade comunidade) {
    	
    	List<Relato> relatosComunidade = null;
    	Session session = null;
    	  
    	try {
        	session = getSessionFactory().openSession();
            session.beginTransaction();
            
            CriteriaBuilder construtor = session.getCriteriaBuilder();
            CriteriaQuery<Relato> criteria = construtor.createQuery(Relato.class);
            Root<Relato> raizRelato = criteria.from(Relato.class);
            
            criteria.select(raizRelato).where(construtor.equal(raizRelato.get(Relato_.COMUNIDADE), comunidade));
            
            ParameterExpression<Comunidade> relatoComunidade = construtor.parameter(Comunidade.class);
			criteria.where(construtor.equal(raizRelato.get(Relato_.COMUNIDADE), relatoComunidade));
            
            relatosComunidade = session.createQuery(criteria).setParameter(relatoComunidade, comunidade).getResultList();
            
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
        return relatosComunidade;
    }

    public List<Relato> recuperarPorCategoria(Categoria categoria) {
        List<Relato> relatosCategoria = null;
        Session session = null;

        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();

            CriteriaBuilder construtor = session.getCriteriaBuilder();
            CriteriaQuery<Relato> criteria = construtor.createQuery(Relato.class);
            Root<Relato> raizRelato = criteria.from(Relato.class);

            ParameterExpression<Categoria> parametroCategoria = construtor.parameter(Categoria.class);
            criteria.select(raizRelato).where(construtor.equal(raizRelato.get(Relato_.CATEGORIA_RELATO), parametroCategoria));

            relatosCategoria = session.createQuery(criteria).setParameter(parametroCategoria, categoria).getResultList();

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return relatosCategoria;
    }
    
    public Relato recuperarPorId(Long id) {

    	Relato relatosPorId = null;
    	Session session = null;
    	  
    	try {
        	session = getSessionFactory().openSession();
            session.beginTransaction();
            
            CriteriaBuilder construtor = session.getCriteriaBuilder();
            CriteriaQuery<Relato> criteria = construtor.createQuery(Relato.class);
            Root<Relato> raizRelato = criteria.from(Relato.class);
            
            criteria.select(raizRelato).where(construtor.equal(raizRelato.get(Relato_.ID), id));
            
            ParameterExpression<Long> relatoPorId = construtor.parameter(Long.TYPE);
			criteria.where(construtor.equal(raizRelato.get(Relato_.ID), relatoPorId));
            
            relatosPorId = session.createQuery(criteria).setParameter(relatoPorId, id).getSingleResult();
            
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
        return relatosPorId;
    }
	
}
