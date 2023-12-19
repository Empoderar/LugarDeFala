package br.senac.lugardefala.modelo.dao.usuario;
 
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
 
public class UsuarioDAOImpl implements UsuarioDAO {
 
    public void inserirUsuario(Usuario usuario) {
        Session sessao = null;
 
        try {
            sessao = conectarBanco().openSession();
            sessao.beginTransaction();
            sessao.save(usuario);
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
 
    public void deletarUsuario(Usuario usuario) {
        Session sessao = null;
 
        try {
            sessao = conectarBanco().openSession();
            sessao.beginTransaction();
            sessao.delete(usuario);
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
 
    public void atualizarUsuario(Usuario usuario) {
        Session sessao = null;
 
        try {
            sessao = conectarBanco().openSession();
            sessao.beginTransaction();
            sessao.update(usuario);
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
 
    public Usuario recuperarUsuarioNome(String nome) {
	   
		Session sessao = null;
		Usuario usuario = null;

		try {
			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
			Root<Usuario> raizUsuario = criteria.from(Usuario.class);

			criteria.select(raizUsuario).where(construtor.equal(raizUsuario.get("nome"), nome));
			usuario = sessao.createQuery(criteria).uniqueResult();
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
		return usuario;
	}
   
	public Usuario recuperarUsuarioComunidade(Comunidade comunidade) {

		Session sessao = null;
		Usuario usuario = null;

		try {
			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
			Root<Usuario> raizUsuario = criteria.from(Usuario.class);

			criteria.select(raizUsuario).where(construtor.equal(raizUsuario.get("comunidade"), comunidade));
			usuario = sessao.createQuery(criteria).uniqueResult();
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
		return usuario;
	}
	
	public Usuario recuperarUsuarioConselho(Conselho conselho) {

		Session sessao = null;
		Usuario usuario = null;

		try {
			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
			Root<Usuario> raizUsuario = criteria.from(Usuario.class);

			criteria.select(raizUsuario).where(construtor.equal(raizUsuario.get("conselho"), conselho));
			usuario = sessao.createQuery(criteria).uniqueResult();
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
		return usuario;
	}
	
	public Usuario recuperarUsuarioDenuncia(Denuncia denuncia) {

		Session sessao = null;
		Usuario usuario = null;

		try {
			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
			Root<Usuario> raizUsuario = criteria.from(Usuario.class);

			criteria.select(raizUsuario).where(construtor.equal(raizUsuario.get("denuncia"), denuncia));
			usuario = sessao.createQuery(criteria).uniqueResult();
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
		return usuario;
	}
	
	public Usuario recuperarUsuarioRelato(Relato relato) {

		Session sessao = null;
		Usuario usuario = null;

		try {
			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
			Root<Usuario> raizUsuario = criteria.from(Usuario.class);

			criteria.select(raizUsuario).where(construtor.equal(raizUsuario.get("relato"), relato));
			usuario = sessao.createQuery(criteria).uniqueResult();
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
		return usuario;
	}
 
    private SessionFactory conectarBanco() {
    	
        Configuration configuracao = new Configuration();
        
        configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.categoria.Categoria.class);
        configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.conselho.Conselho.class);
        configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.comunidade.Comunidade.class);
        configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.contato.Contato.class);
        configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.denuncia.Denuncia.class);
        configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.denuncia.DenunciaModerador.class);
		configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.denuncia.DenunciaRelato.class);
		configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.denuncia.DenunciaConselho.class);
		configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.denuncia.DenunciaUsuario.class);
        configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.moderador.Moderador.class);
        configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.relato.Relato.class);
        configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.usuario.Usuario.class);
        configuracao.configure("hibernate.cfg.xml");
        ServiceRegistry servico = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
        SessionFactory fabricaSessao = configuracao.buildSessionFactory(servico);
        return fabricaSessao;
    }
 
}