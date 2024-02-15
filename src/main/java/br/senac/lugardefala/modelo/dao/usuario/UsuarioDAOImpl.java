package br.senac.lugardefala.modelo.dao.usuario;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
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
import br.senac.lugardefala.modelo.entidade.contato.Contato;
import br.senac.lugardefala.modelo.entidade.contato.Contato_;
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
		configuration.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.foto.Foto.class);	

		configuration.configure("hibernate.cfg.xml");

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void inserir(Usuario usuario) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();
			session.save(usuario);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao inserir usuário: " + e.getMessage());
		}
	}

	public void deletar(Usuario usuario) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();
			session.delete(usuario);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao deletar usuário: " + e.getMessage());
		}
	}

	public void atualizar(Usuario usuario) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();

			if (usuario.getId() != null && session.get(Usuario.class, usuario.getId()) != null) {
				session.update(usuario);
			} else {
				System.out.println("Erro: Tentativa de atualizar uma entidade não gerenciada ou com ID nulo.");
			}

			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao atualizar usuário: " + e.getMessage());
		}
	}

	public Usuario recuperarPorNome(String nome) {
		Session session = null;
		Usuario usuariosPeloNome = null;
		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();
			
			CriteriaBuilder construtor = session.getCriteriaBuilder();
			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
			Root<Usuario> raizUsuario = criteria.from(Usuario.class);
			ParameterExpression<String> usuarioPeloNome = construtor.parameter(String.class, Usuario_.NOME);
			
			criteria.select(raizUsuario).where(construtor.equal(raizUsuario.get(Usuario_.NOME), usuarioPeloNome));
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

	public Usuario recuperarPorApelido(String apelido) {
		Session session = null;
		Usuario usuariosPeloApelido = null;
		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();
			
			CriteriaBuilder construtor = session.getCriteriaBuilder();
			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
			Root<Usuario> raizUsuario = criteria.from(Usuario.class);
			ParameterExpression<String> usuarioPeloApelido = construtor.parameter(String.class, Usuario_.APELIDO);
			
			criteria.select(raizUsuario).where(construtor.equal(raizUsuario.get(Usuario_.APELIDO), usuarioPeloApelido));
			usuariosPeloApelido = session.createQuery(criteria).setParameter(usuarioPeloApelido, apelido)
					.getSingleResult();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return usuariosPeloApelido;
	}

	public List<Usuario> recuperarTodos() {

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

	public List<Usuario> recuperarPorComunidade(Comunidade comunidade) {
		List<Usuario> usuariosComunidade = null;
		Session session = null;

		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();

			CriteriaBuilder construtor = session.getCriteriaBuilder();
			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
			Root<Usuario> raizUsuario = criteria.from(Usuario.class);
			Join<Usuario, Comunidade> joinComunidades = raizUsuario.join(Usuario_.COMUNIDADES);

			ParameterExpression<Comunidade> comunidadeParam = construtor.parameter(Comunidade.class);
			criteria.select(raizUsuario).where(construtor.equal(joinComunidades, comunidadeParam));

			usuariosComunidade = session.createQuery(criteria).setParameter(comunidadeParam, comunidade)
					.getResultList();

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return usuariosComunidade;
	}

	public List<Usuario> recuperarPorConselho(Conselho conselho) {
		Session session = null;
		List<Usuario> usuarios = null;

		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();

			CriteriaBuilder construtor = session.getCriteriaBuilder();
			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
			Root<Usuario> raizUsuario = criteria.from(Usuario.class);

			Join<Usuario, Conselho> joinConselho = raizUsuario.join(Usuario_.CONSELHOS);

			criteria.where(construtor.equal(joinConselho.get(Usuario_.ID), conselho.getId()));
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

	public Usuario recuperarPorIdDenuncia(Long id) {
		Usuario usuario = null;
		Session session = null;

		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Usuario> criteria = builder.createQuery(Usuario.class);
			Root<Usuario> root = criteria.from(Usuario.class);

			criteria.select(root).where(builder.equal(root.get(Usuario_.ID), id));

			usuario = session.createQuery(criteria).uniqueResult();

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return usuario;
	}

	public List<Usuario> recuperarPorRelato(Relato relato) {
		Session session = null;
		List<Usuario> usuarios = null;

		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();

			CriteriaBuilder construtor = session.getCriteriaBuilder();
			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
			Root<Usuario> raizUsuario = criteria.from(Usuario.class);

			Join<Usuario, Relato> joinRelato = raizUsuario.join(Usuario_.RELATOS);

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

	public Usuario recuperarPorId(Long id) {
		Session session = null;
		Usuario usuariosPeloId = null;
		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();
			
			CriteriaBuilder construtor = session.getCriteriaBuilder();
			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
			Root<Usuario> raizUsuario = criteria.from(Usuario.class);
			ParameterExpression<Long> usuarioPeloId = construtor.parameter(Long.class, Usuario_.ID);
			
			criteria.select(raizUsuario).where(construtor.equal(raizUsuario.get(Usuario_.ID), usuarioPeloId));
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

	public Usuario recuperarPorIdFetch(Long id) {
		Session session = null;
		Usuario usuariosPeloId = null;
		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();
			
			CriteriaBuilder construtor = session.getCriteriaBuilder();
			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
			Root<Usuario> raizUsuario = criteria.from(Usuario.class);
			
			raizUsuario.fetch(Usuario_.COMUNIDADES, JoinType.LEFT);
			ParameterExpression<Long> usuarioPeloId = construtor.parameter(Long.class, Usuario_.ID);
			
			criteria.select(raizUsuario).where(construtor.equal(raizUsuario.get(Usuario_.ID), usuarioPeloId));
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

	public boolean verificarCredenciais(String apelido, String senha) {
		Session session = null;
		Usuario usuario = null;

		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();

			CriteriaBuilder construtor = session.getCriteriaBuilder();
			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
			Root<Usuario> raizUsuario = criteria.from(Usuario.class);

			criteria.select(raizUsuario);

			criteria.where(construtor.equal(raizUsuario.get(Usuario_.apelido), apelido),
					construtor.equal(raizUsuario.get(Usuario_.senha), senha));

			usuario = session.createQuery(criteria).uniqueResult();

			session.getTransaction().commit();

		} catch (Exception sqException) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return usuario != null;
	}
	public Usuario obterPorCredenciais(String email, String senha) {
	    Session session = null;
	    Usuario usuario = null;
	 
	    try {
	        session = getSessionFactory().openSession();
	        session.beginTransaction();
	 
	        CriteriaBuilder construtor = session.getCriteriaBuilder();
	        CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
	        Root<Usuario> raizUsuario = criteria.from(Usuario.class);
	        Join<Usuario, Contato> raizContato = raizUsuario.join(Usuario_.CONTATO);
	 
	        Predicate predicateUsuarioLogin = construtor.and(
	                construtor.equal(raizUsuario.get(Usuario_.SENHA), senha),
	                construtor.equal(raizContato.get(Contato_.EMAIL), email)
	        );
	 
	        criteria.select(raizUsuario).where(predicateUsuarioLogin);
	 
	        usuario = session.createQuery(criteria).uniqueResult();
	 
	        return usuario;
	 
	    } catch (Exception sqlException) {
	        sqlException.printStackTrace();
	 
	        if (session.getTransaction() != null) {
	            session.getTransaction().rollback();
	        }
	 
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	 
	    return usuario;
	}
}
