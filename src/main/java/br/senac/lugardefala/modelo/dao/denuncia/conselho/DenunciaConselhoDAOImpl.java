package br.senac.lugardefala.modelo.dao.denuncia.conselho;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import br.senac.lugardefala.modelo.entidade.denuncia.Denuncia;
import br.senac.lugardefala.modelo.entidade.denuncia.DenunciaConselho;
import br.senac.lugardefala.modelo.entidade.denuncia.DenunciaConselho_;
import br.senac.lugardefala.modelo.enumeracao.Status;

public class DenunciaConselhoDAOImpl implements DenunciaConselhoDAO {

    private static final SessionFactory sessionFactory;

    static {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.categoria.Categoria.class);
        configuration.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.conselho.Conselho.class);
        configuration.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.comunidade.Comunidade.class);
        configuration.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.contato.Contato.class);
        configuration.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.denuncia.Denuncia.class);
        configuration.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.denuncia.DenunciaModerador.class);
        configuration.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.denuncia.DenunciaRelato.class);
        configuration.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.denuncia.DenunciaConselho.class);
        configuration.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.denuncia.DenunciaUsuario.class);
        configuration.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.moderador.Moderador.class);
        configuration.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.relato.Relato.class);
        configuration.addAnnotatedClass(br.senac.lugardefala.modelo.entidade.usuario.Usuario.class);

        configuration.configure("hibernate.cfg.xml");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    private SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void inserirDenunciaConselho(Denuncia denuncia) {
        try (Session session = getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(denuncia);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletarDenunciaConselho(Denuncia denuncia) {
        try (Session session = getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(denuncia);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<DenunciaConselho> recuperarDenunciaDeConselhoStatus(Status status) {
	Session session = null;
	List<DenunciaConselho> denunciasConselhos = null;
	try {
		session = getSessionFactory().openSession();
		session.beginTransaction();

		CriteriaBuilder criteriaConstrutor = session.getCriteriaBuilder();
		CriteriaQuery<DenunciaConselho> criteriaConsulta = criteriaConstrutor.createQuery(DenunciaConselho.class);
		Root<DenunciaConselho> raizDenunciaConselho = criteriaConsulta.from(DenunciaConselho.class);


		Predicate predicateDenunciaRelatoStatus
		= criteriaConstrutor.equal(raizDenunciaConselho.get(DenunciaConselho_.status), status);

		criteriaConsulta.where(predicateDenunciaRelatoStatus);
		denunciasConselhos = session.createQuery(criteriaConsulta).getResultList();
		session.getTransaction().commit();

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if (session != null) {
			session.close();
		}
	}
	return denunciasConselhos;
}

//	Nao funciona 
//public List<DenunciaConselho> recuperarDenunciaDeConselhoRelato(Relato relato) {
//	Session session = null;
//	List<DenunciaConselho> denunciasConselhos = null;
//	try {
//		session = getSessionFactory().openSession();
//		session.beginTransaction();
//		
//		CriteriaBuilder criteriaConstrutor = session.getCriteriaBuilder();
//		CriteriaQuery<DenunciaConselho> criteriaConsulta = criteriaConstrutor.createQuery(DenunciaConselho.class);
//		Root<DenunciaConselho> raizDenunciaConselho = criteriaConsulta.from(DenunciaConselho.class);
//		
//		
//		Predicate predicateDenunciaConselhoRelato
//		= criteriaConstrutor.equal(raizDenunciaConselho.get(DenunciaConselho_.relato), relato);
//		
//		criteriaConsulta.where(predicateDenunciaConselhoRelato);
//		denunciasConselhos = session.createQuery(criteriaConsulta).getResultList();
//		session.getTransaction().commit();
//		
//	} catch (Exception e) {
//		e.printStackTrace();
//	} finally {
//		if (session != null) {
//			session.close();
//		}
//	}
//	return denunciasConselhos;
//}

}
