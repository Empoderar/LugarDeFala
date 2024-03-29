package br.senac.lugardefala.modelo.dao.usuario;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.conselho.Conselho;
import br.senac.lugardefala.modelo.entidade.denuncia.Denuncia;
import br.senac.lugardefala.modelo.entidade.relato.Relato;
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
			System.out.println("Erro ao inserir usuário: " + e.getMessage());
		}
	}

	public void deletarUsuario(Usuario usuario) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();
			session.delete(usuario);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao deletar usuário: " + e.getMessage());
		}
	}

	public void atualizarUsuario(Usuario usuario) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();
			session.update(usuario);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao atualizar usuário: " + e.getMessage());
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

	public List<Usuario> recuperarUsuarios() {

		Session sessao = null;
		List<Usuario> usuarios = null;

		try {

			sessao = getSessionFactory().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
			Root<Usuario> raizUsuario = criteria.from(Usuario.class);

			criteria.select(raizUsuario);

			usuarios = sessao.createQuery(criteria).getResultList();

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

		return usuarios;
	}

	public List<Usuario> recuperarUsuariosPorComunidade(Comunidade comunidade) {
	    Session session = null;
	    List<Usuario> usuarios = null;

	    try {
	        session = getSessionFactory().openSession();
	        session.beginTransaction();

	        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
	        CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
	        Root<Usuario> root = criteriaQuery.from(Usuario.class);

	        Predicate predicate = criteriaBuilder.isMember(comunidade, root.get("comunidades"));

	        criteriaQuery.select(root).where(predicate);

	        usuarios = session.createQuery(criteriaQuery).getResultList();

	        session.getTransaction().commit();

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }

	    return usuarios;
	}


	public List<Usuario> recuperarUsuariosPorConselho(Conselho conselho) {
	    Session session = null;
	    List<Usuario> usuarios = null;

	    try {
	        session = getSessionFactory().openSession();
	        session.beginTransaction();

	        CriteriaBuilder construtor = session.getCriteriaBuilder();
	        CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
	        Root<Usuario> raizUsuario = criteria.from(Usuario.class);

	        Join<Usuario, Conselho> joinConselho = raizUsuario.join("conselhos");

	        criteria.where(construtor.equal(joinConselho.get("id"), conselho.getId()));
	        usuarios = session.createQuery(criteria).getResultList();
	        session.getTransaction().commit();
	        return usuarios;

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	    return usuarios;
	}

	public List<Usuario> recuperarUsuariosPorDenuncia(Denuncia denuncia) {
	    Session session = null;
	    List<Usuario> usuarios = null;

	    try {
	        session = getSessionFactory().openSession();
	        session.beginTransaction();

	        CriteriaBuilder construtor = session.getCriteriaBuilder();
	        CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
	        Root<Usuario> raizUsuario = criteria.from(Usuario.class);

	        Join<Usuario, Denuncia> joinDenuncia = raizUsuario.join("denunciasDeUsuario");

	        criteria.where(construtor.equal(joinDenuncia.get("id"), denuncia.getId()));
	        usuarios = session.createQuery(criteria).getResultList();

	        session.getTransaction().commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }

	    return usuarios;
	}


	public List<Usuario> recuperarUsuariosPorRelato(Relato relato) {
	    Session session = null;
	    List<Usuario> usuarios = null;

	    try {
	        session = getSessionFactory().openSession();
	        session.beginTransaction();

	        CriteriaBuilder construtor = session.getCriteriaBuilder();
	        CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
	        Root<Usuario> raizUsuario = criteria.from(Usuario.class);

	        Join<Usuario, Relato> joinRelato = raizUsuario.join("relatos");

	        criteria.select(raizUsuario).where(construtor.equal(joinRelato, relato));
	        usuarios = session.createQuery(criteria).getResultList();

	        session.getTransaction().commit();
	        return usuarios;

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	    return usuarios;
	}


	public Usuario recuperarUsuarioPeloId(Long id) {
		Session session = null;
		Usuario usuariosPeloId = null;
		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();
			CriteriaBuilder construtor = session.getCriteriaBuilder();
			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
			Root<Usuario> raizUsuario = criteria.from(Usuario.class);
			ParameterExpression<Long> usuarioPeloId = construtor.parameter(Long.class, "id");
			criteria.select(raizUsuario).where(construtor.equal(raizUsuario.get("id"), usuarioPeloId));
			usuariosPeloId = session.createQuery(criteria).setParameter(usuarioPeloId, id).getSingleResult();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return usuariosPeloId;
	}

}