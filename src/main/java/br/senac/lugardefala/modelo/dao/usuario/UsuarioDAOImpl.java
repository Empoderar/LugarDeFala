package br.senac.lugardefala.modelo.dao.usuario;
 
import java.util.List;
 
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

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
 
    public List<Usuario> recuperarUsuario() {
        Session sessao = null;
        List<Usuario> usuarios = null;
 
        try {
            sessao = conectarBanco().openSession();
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
 
    private SessionFactory conectarBanco() {
    	
        Configuration configuracao = new Configuration();
        
        configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.categoria.Categoria.class);
        configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.conselho.Conselho.class);
        configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.comunidade.Comunidade.class);
        configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.contato.Contato.class);
        configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.denuncia.Denuncia.class);
        configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.moderador.Moderador.class);
        configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.relato.Relato.class);
        configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.status.Status.class);
        configuracao.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.usuario.Usuario.class);
        configuracao.configure("hibernate.cfg.xml");
        ServiceRegistry servico = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
        SessionFactory fabricaSessao = configuracao.buildSessionFactory(servico);
        return fabricaSessao;
    }
 
}