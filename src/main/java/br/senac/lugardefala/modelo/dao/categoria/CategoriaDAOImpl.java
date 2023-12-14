package br.senac.modelo.dao.categoria;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import br.senac.modelo.entidade.categoria.Categoria;

public class CategoriaDAOImpl implements CategoriaDAO {
	
	public void inserirCliente(Categoria categoria) {

		Session sessao = null;

		try {
			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.save(categoria);

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

	public void deletarCategoria(Categoria categoria) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.delete(categoria);

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

	public void atualizarCategoria(Categoria categoria) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.update(categoria);

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

		configuracao.configure("hibernate.cfg.xml");

		ServiceRegistry servico = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties())
				.build();
		SessionFactory fabricaSessao = configuracao.buildSessionFactory(servico);

		return fabricaSessao;

	}

	@Override
	public void inserirCategoria() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletarCategoria() {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizarCategoria() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Categoria> recuperarClientes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categoria recuperarContatoCliente(Categoria categoria) {
		// TODO Auto-generated method stub
		return null;
	}
}