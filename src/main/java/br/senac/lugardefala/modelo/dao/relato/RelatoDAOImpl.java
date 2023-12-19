package br.senac.lugardefala.modelo.dao.relato;

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
import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.relato.Relato;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;
import br.senac.lugardefala.modelo.enumeracao.Status;

public class RelatoDAOImpl implements RelatoDAO {

	public void inserirRelato(Relato relato) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.save(relato);
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

	public void deletarRelato(Relato relato) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.delete(relato);

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

	public void atualizarRelato(Relato relato) {
		Session sessao = null;

		try {
			sessao = conectarBanco().openSession();
			sessao.beginTransaction();
			sessao.update(relato);
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

	public List<Relato> recuperarRelato() {
		Session sessao = null;
		List<Relato> relato = null;

		try {
			sessao = conectarBanco().openSession();
			sessao.beginTransaction();
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Relato> criteria = construtor.createQuery(Relato.class);
			Root<Relato> raizRelato = criteria.from(Relato.class);
			criteria.select(raizRelato);
			relato = sessao.createQuery(criteria).getResultList();
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

		return relato;
	}
	
	public Relato recuperarRelatoUsuario(Usuario usuario) {
		 
		Session sessao = null;
		Relato relato = null;

		try {
			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Relato> criteria = construtor.createQuery(Relato.class);
			Root<Relato> raizRelato = criteria.from(Relato.class);

			criteria.select(raizRelato).where(construtor.equal(raizRelato.get("usuario"), usuario));
			relato = sessao.createQuery(criteria).uniqueResult();
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
		return relato;
	}
	
	public Relato recuperarRelatoStatus(Status status) {
		 
		Session sessao = null;
		Relato relato = null;

		try {
			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Relato> criteria = construtor.createQuery(Relato.class);
			Root<Relato> raizRelato = criteria.from(Relato.class);

			criteria.select(raizRelato).where(construtor.equal(raizRelato.get("status"), status));
			relato = sessao.createQuery(criteria).uniqueResult();
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
		return relato;
	}
	
	public Relato recuperarRelatoComunidade(Comunidade comunidade) {
		 
		Session sessao = null;
		Relato relato = null;

		try {
			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Relato> criteria = construtor.createQuery(Relato.class);
			Root<Relato> raizRelato = criteria.from(Relato.class);

			criteria.select(raizRelato).where(construtor.equal(raizRelato.get("comunidade"), comunidade));
			relato = sessao.createQuery(criteria).uniqueResult();
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
		return relato;
	}
	
	public Relato recuperarRelatoCategoria(Categoria categoria) {
		 
		Session sessao = null;
		Relato relato = null;

		try {
			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Relato> criteria = construtor.createQuery(Relato.class);
			Root<Relato> raizRelato = criteria.from(Relato.class);

			criteria.select(raizRelato).where(construtor.equal(raizRelato.get("categoria"), categoria));
			relato = sessao.createQuery(criteria).uniqueResult();
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
		return relato;
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
