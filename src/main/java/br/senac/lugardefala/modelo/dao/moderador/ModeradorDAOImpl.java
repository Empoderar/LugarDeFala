package br.senac.lugardefala.modelo.dao.moderador;

import java.util.List;

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

public class ModeradorDAOImpl implements ModeradorDAO {
    public void inserirModerador(Moderador moderador) {
        Session sessao = null;
        try {
            sessao = conectarBanco().openSession();
            sessao.beginTransaction();
            sessao.save(moderador);
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
    public void deletarModerador(Moderador moderador) {
        Session sessao = null;
        try {
            sessao = conectarBanco().openSession();
            sessao.beginTransaction();
            sessao.delete(moderador);
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
    public void atualizarModerador(Moderador moderador) {
        Session sessao = null;
        try {
            sessao = conectarBanco().openSession();
            sessao.beginTransaction();
            sessao.update(moderador);
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
    public List<Moderador> recuperarModeradores() {
        Session sessao = null;
        List<Moderador> moderadores = null;
        try {
            sessao = conectarBanco().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Moderador> criteria = construtor.createQuery(Moderador.class);
            Root<Moderador> raizmoderador = criteria.from(Moderador.class);
            criteria.select(raizmoderador);
            moderadores = sessao.createQuery(criteria).getResultList();
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
        return moderadores;
    }
    
	public Moderador recuperarModeradorNome(String nome) {
 
		Session sessao = null;
		Moderador moderador = null;
 
		try {
			sessao = conectarBanco().openSession();
			sessao.beginTransaction();
 
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Moderador> criteria = construtor.createQuery(Moderador.class);
			Root<Moderador> raizModerador = criteria.from(Moderador.class);
 
			criteria.select(raizModerador).where(construtor.equal(raizModerador.get("nome"), nome));
			moderador = sessao.createQuery(criteria).uniqueResult();
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
		return moderador;
	}
 
	public Moderador recuperarModeradorComunidade(Comunidade comunidade) {
 
		Session sessao = null;
		Moderador moderador = null;
 
		try {
			sessao = conectarBanco().openSession();
			sessao.beginTransaction();
 
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Moderador> criteria = construtor.createQuery(Moderador.class);
			Root<Moderador> raizModerador = criteria.from(Moderador.class);
 
			criteria.select(raizModerador).where(construtor.equal(raizModerador.get("comunidade"), comunidade));
			moderador = sessao.createQuery(criteria).uniqueResult();
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
		return moderador;
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