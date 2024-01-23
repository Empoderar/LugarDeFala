package br.senac.lugardefala.modelo.dao.usuario;

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

import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.conselho.Conselho;
import br.senac.lugardefala.modelo.entidade.denuncia.Denuncia;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario_;


public class UsuarioDAOImpl implements UsuarioDAO {

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

	public void inserirUsuario(Usuario usuario) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();
			session.save(usuario);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deletarUsuario(Usuario usuario) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();
			session.delete(usuario);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void atualizarUsuario(Usuario usuario) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();
			session.update(usuario);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Usuario buscarUsuarioPeloNome(String nome) {
	    Session session = null;
	    Usuario usuariosPeloNome = null;
	    try {
	        session = getSessionFactory().openSession();
	        session.beginTransaction();
	        CriteriaBuilder construtor = session.getCriteriaBuilder();
	        CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
	        Root<Usuario> raizUsuario = criteria.from(Usuario.class);
	        ParameterExpression<String> usuarioPeloNome = construtor.parameter(String.class, "nome");
	        criteria.select(raizUsuario).where(construtor.equal(raizUsuario.get("nome"), usuarioPeloNome));
	        usuariosPeloNome = session.createQuery(criteria).setParameter(usuarioPeloNome, nome).getSingleResult();
	        session.getTransaction().commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	    return usuariosPeloNome;
	}

//	public List<Usuario> recuperarUsuariosPorComunidade(Comunidade comunidade) {
//		Session session = null;
//		List<Usuario> usuario = null;
//
//		try {
//			session = getSessionFactory().openSession();
//			session.beginTransaction();
//			CriteriaBuilder construtor = session.getCriteriaBuilder();
//			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
//			Root<Usuario> raizUsuario = criteria.from(Usuario.class);
//			criteria.select(raizUsuario).where(construtor.equal(raizUsuario.get("comunidade"), comunidade));
//			usuario = session.createQuery(criteria).getResultList();
//			session.getTransaction().commit();
//			return usuario;
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//		return usuario;
//	}

//	public Usuario recuperarUsuarioPorConselho(Conselho conselho) {
//		Session session = null;
//		Usuario usuario = null;
//
//		try {
//			session = getSessionFactory().openSession();
//			session.beginTransaction();
//			
//			CriteriaBuilder construtor = session.getCriteriaBuilder();
//			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
//			Root<Usuario> raizUsuario = criteria.from(Usuario.class);
//			
//			criteria.select(raizUsuario).where(construtor.equal(raizUsuario.get(Usuario_.conselhos), conselho));
//			usuario = session.createQuery(criteria).getSingleResult();
//			session.getTransaction().commit();
//			return usuario;
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//		return usuario;
//	}
//
//	public 	List<Usuario> recuperarUsuariosPorDenuncia(Denuncia denuncia) {
//		Session session = null;
//		List<Usuario> usuario = null;
//
//		try {
//			session = getSessionFactory().openSession();
//			session.beginTransaction();
//			CriteriaBuilder construtor = session.getCriteriaBuilder();
//
//			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
//			Root<Usuario> raizUsuario = criteria.from(Usuario.class);
//
//			criteria.where(construtor.equal(raizUsuario.get(Usuario_.denunciasDeUsuario), denuncia));
//
//			usuario = session.createQuery(criteria).getResultList();
//
//			session.getTransaction().commit();
//
//		} catch (Exception e) {
//
//			e.printStackTrace();
//			return null;
//		} finally {
//
//			if (session != null) {
//				session.close();
//			}
//		}
//
//		return usuario;
//
//	}
//
//	public List<Usuario> recuperarUsuariosPorRelato(Relato relato) {
//		Session session = null;
//		List<Usuario> usuario = null;
//
//		try {
//			session = getSessionFactory().openSession();
//			session.beginTransaction();
//			CriteriaBuilder construtor = session.getCriteriaBuilder();
//			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
//			Root<Usuario> raizUsuario = criteria.from(Usuario.class);
//			criteria.select(raizUsuario).where(construtor.equal(raizUsuario.get(Usuario_.relatos), relato));
//			usuario = session.createQuery(criteria).getResultList();
//			session.getTransaction().commit();
//			return usuario;
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//		return usuario;
//
//	}

}