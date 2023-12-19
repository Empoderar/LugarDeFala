package br.senac.lugardefala.modelo.dao.comunidade;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.moderador.Moderador;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;

public class ComunidadeDAOImpl implements ComunidadeDAO {

	public void inserirComunidade(Comunidade comunidade) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.save(comunidade);
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

	public void deletarComunidade(Comunidade comunidade) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.delete(comunidade);

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

	public Comunidade recuperarComunidadeModerador(Moderador moderador) {

		Session sessao = null;
		Comunidade comunidade = null;

		try {
			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Comunidade> criteria = construtor.createQuery(Comunidade.class);
			Root<Comunidade> raizComunidade = criteria.from(Comunidade.class);

			criteria.select(raizComunidade).where(construtor.equal(raizComunidade.get("moderador"), moderador));
			comunidade = sessao.createQuery(criteria).uniqueResult();
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
		return comunidade;
	}
	
	public Comunidade recuperarComunidadeUsuario(Usuario usuario) {

		Session sessao = null;
		Comunidade comunidade = null;

		try {
			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Comunidade> criteria = construtor.createQuery(Comunidade.class);
			Root<Comunidade> raizComunidade = criteria.from(Comunidade.class);

			criteria.select(raizComunidade).where(construtor.equal(raizComunidade.get("usuario"), usuario));
			comunidade = sessao.createQuery(criteria).uniqueResult();
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
		return comunidade;
	}
	
	public Comunidade recuperarComunidadeNome(String nome) {

		Session sessao = null;
		Comunidade comunidade = null;

		try {
			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Comunidade> criteria = construtor.createQuery(Comunidade.class);
			Root<Comunidade> raizComunidade = criteria.from(Comunidade.class);

			criteria.select(raizComunidade).where(construtor.equal(raizComunidade.get("nome"), nome));
			comunidade = sessao.createQuery(criteria).uniqueResult();
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
		return comunidade;
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
