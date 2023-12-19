package br.senac.lugardefala.modelo.dao.contato;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import br.senac.lugardefala.modelo.entidade.contato.Contato;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;

public class ContatoDAOImpl implements ContatoDAO {
	 
	public void inserirContato(Contato contato) {
 
		Session sessao = null;
 
		try {
 
			sessao = conectarBanco().openSession();
			sessao.beginTransaction();
 
			sessao.save(contato);
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
 
	public void atualizarContato(Contato contato) {
 
		Session sessao = null;
 
		try {
 
			sessao = conectarBanco().openSession();
			sessao.beginTransaction();
 
			sessao.update(contato);
 
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
 
   public Contato recuperarContatoUsuario(Usuario usuario) {
    	
        Session sessao = null;
        Contato contato = null;
 
        try {
            sessao = conectarBanco().openSession();
            sessao.beginTransaction();

            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Contato> criteria = construtor.createQuery(Contato.class);
            Root<Contato> raizContato = criteria.from(Contato.class);

            criteria.select(raizContato).where(construtor.equal(raizContato.get("usuario"), usuario));
            contato = sessao.createQuery(criteria).uniqueResult();
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
        return contato;
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

		ServiceRegistry servico = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
		SessionFactory fabricaSessao = configuracao.buildSessionFactory(servico);

		return fabricaSessao;
	}

}