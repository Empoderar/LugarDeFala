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
import br.senac.lugardefala.modelo.entidade.relato.Relato;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;
import br.senac.lugardefala.modelo.enumeracao.Status;

public class DenunciaDAOImpl implements DenunciaDAO {

	public void inserirDenuncia(Denuncia denuncia) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.save(denuncia);
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

	public void deletarDenuncia(Denuncia denuncia) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.delete(denuncia);

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

	public void atualizarDenuncia(Denuncia denuncia) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.update(denuncia);

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

	public Denuncia recuperarDenunciaUsuario(Usuario usuario) {

		Session sessao = null;

		Denuncia denuncia = null;

		try {
			sessao = conectarBanco().openSession();
			sessao.beginTransaction();
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Denuncia> criteria = construtor.createQuery(Denuncia.class);
			Root<Denuncia> raizDenuncia = criteria.from(Denuncia.class);

			criteria.select(raizDenuncia).where(construtor.equal(raizDenuncia.get("usuario"), usuario));
			denuncia = sessao.createQuery(criteria).uniqueResult();
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
		return denuncia;
	}
	
	public Denuncia recuperarDenunciaDeRelatoStatus(Relato relato,Status status) {
 
		Session sessao = null;
		Denuncia denuncia = null;
 
		try {
			sessao = conectarBanco().openSession();
			sessao.beginTransaction();
 
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Denuncia> criteria = construtor.createQuery(Denuncia.class);
			Root<Denuncia> raizDenuncia = criteria.from(Denuncia.class);
 
			criteria.select(raizDenuncia).where(
		            construtor.equal(raizDenuncia.get("relato"), relato),
		            construtor.equal(raizDenuncia.get("status"), status)
		        );
			denuncia = sessao.createQuery(criteria).uniqueResult();
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
		return denuncia;
	}
 
	public Denuncia recuperarDenunciaDeRelatoRelato(Relato relato) {
 
		Session sessao = null;
		Denuncia denuncia = null;
 
		try {
			sessao = conectarBanco().openSession();
			sessao.beginTransaction();
 
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Denuncia> criteria = construtor.createQuery(Denuncia.class);
			Root<Denuncia> raizDenuncia = criteria.from(Denuncia.class);
 
			criteria.select(raizDenuncia).where(construtor.equal(raizDenuncia.get("relato"), relato));
			denuncia = sessao.createQuery(criteria).uniqueResult();
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
		return denuncia;
	}
 
	public Denuncia recuperarDenunciaDeConselhoStatus(Conselho conselho,Status status) {
 
		Session sessao = null;
		Denuncia denuncia = null;
 
		try {
			sessao = conectarBanco().openSession();
			sessao.beginTransaction();
 
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Denuncia> criteria = construtor.createQuery(Denuncia.class);
			Root<Denuncia> raizDenuncia = criteria.from(Denuncia.class);
 
			criteria.select(raizDenuncia).where(
		            construtor.equal(raizDenuncia.get("conselho"), conselho),
		            construtor.equal(raizDenuncia.get("status"), status)
		        );
			denuncia = sessao.createQuery(criteria).uniqueResult();
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
		return denuncia;
	}
 
	public Denuncia recuperarDenunciaDeConselhoRelato(Conselho conselho,Relato relato) {
 
		Session sessao = null;
		Denuncia denuncia = null;
 
		try {
			sessao = conectarBanco().openSession();
			sessao.beginTransaction();
 
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Denuncia> criteria = construtor.createQuery(Denuncia.class);
			Root<Denuncia> raizDenuncia = criteria.from(Denuncia.class);
 
			criteria.select(raizDenuncia).where(
		            construtor.equal(raizDenuncia.get("conselho"), conselho),
		            construtor.equal(raizDenuncia.get("relato"), relato)
		        );
			denuncia = sessao.createQuery(criteria).uniqueResult();
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
		return denuncia;
	}
 
	public Denuncia recuperarDenunciaDeUsuarioStatus(Usuario usuario, Status status) {
 
		Session sessao = null;
		Denuncia denuncia = null;
 
		try {
			sessao = conectarBanco().openSession();
			sessao.beginTransaction();
 
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Denuncia> criteria = construtor.createQuery(Denuncia.class);
			Root<Denuncia> raizDenuncia = criteria.from(Denuncia.class);
 
			criteria.select(raizDenuncia).where(
		            construtor.equal(raizDenuncia.get("usuario"), usuario),
		            construtor.equal(raizDenuncia.get("status"), status)
		        );
			denuncia = sessao.createQuery(criteria).uniqueResult();
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
		return denuncia;
	}
 
	public Denuncia recuperarDenunciaDeUsuarioUsuario(Usuario usuario) {
 
		Session sessao = null;
		Denuncia denuncia = null;
 
		try {
			sessao = conectarBanco().openSession();
			sessao.beginTransaction();
 
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Denuncia> criteria = construtor.createQuery(Denuncia.class);
			Root<Denuncia> raizDenuncia = criteria.from(Denuncia.class);
 
			criteria.select(raizDenuncia).where(construtor.equal(raizDenuncia.get("usuario"), usuario));
			denuncia = sessao.createQuery(criteria).uniqueResult();
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
		return denuncia;
	}
 

	private SessionFactory conectarBanco() {

		Configuration configuracao = new Configuration();

		configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.categoria.Categoria.class);
		configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.conselho.Conselho.class);
		configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.comunidade.Comunidade.class);
		configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.contato.Contato.class);
		configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.denuncia.Denuncia.class);
		configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.moderador.Moderador.class);
		configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.relato.Relato.class);
		configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.usuario.Usuario.class);

		configuracao.configure("hibernate.cfg.xml");

		ServiceRegistry servico = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties())
				.build();
		SessionFactory fabricaSessao = configuracao.buildSessionFactory(servico);

		return fabricaSessao;
	}

}
