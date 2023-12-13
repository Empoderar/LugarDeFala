package br.senac.modelo.dao.relato;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import br.senac.modelo.entidade.relato.Relato;
import br.senac.modelo.entidade.usuario.Usuario;

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

	private SessionFactory conectarBanco() {

		Configuration configuracao = new Configuration();

		configuracao.addAnnotatedClass(br.senac.modelo.entidade.categoria.Categoria.class);
		configuracao.addAnnotatedClass(br.senac.modelo.entidade.conselho.Conselho.class);
		configuracao.addAnnotatedClass(br.senac.modelo.entidade.comunidade.Comunidade.class);
		configuracao.addAnnotatedClass(br.senac.modelo.entidade.contato.Contato.class);
		configuracao.addAnnotatedClass(br.senac.modelo.entidade.denuncia.Denuncia.class);
		configuracao.addAnnotatedClass(br.senac.modelo.entidade.moderador.Moderador.class);
		configuracao.addAnnotatedClass(br.senac.modelo.entidade.relato.Relato.class);
		configuracao.addAnnotatedClass(br.senac.modelo.entidade.status.Status.class);
		configuracao.addAnnotatedClass(br.senac.modelo.entidade.usuario.Usuario.class);

		configuracao.configure("hibernate.cfg.xml");

		ServiceRegistry servico = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties())
				.build();
		SessionFactory fabricaSessao = configuracao.buildSessionFactory(servico);

		return fabricaSessao;
	}

	@Override
	public List<Relato> recuperarRelatos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Relato recuperarRelatoUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}