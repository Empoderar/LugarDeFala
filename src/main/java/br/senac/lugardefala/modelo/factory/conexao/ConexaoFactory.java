package br.senac.lugardefala.modelo.factory.conexao;

	import org.hibernate.SessionFactory;
	import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
	import org.hibernate.cfg.Configuration;
	import org.hibernate.service.ServiceRegistry;

	public class ConexaoFactory {

		public SessionFactory getConexao() {

			Configuration configuracao = new Configuration();

			configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.contato.Contato.class);
			configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.categoria.Categoria.class);
			configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.conselho.Conselho.class);
			configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.comunidade.Comunidade.class);
			configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.denuncia.Denuncia.class);
			configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.moderador.Moderador.class);
			configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.relato.Relato.class);
			configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.usuario.Usuario.class);
			configuracao.configure("hibernate.cfg.xml");

			ServiceRegistry servico = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
			SessionFactory fabricaSessao = configuracao.buildSessionFactory(servico);

			return fabricaSessao;
		}
	}

