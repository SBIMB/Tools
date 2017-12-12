/**
 * 
 */
package za.ac.wits.sbimb.awigen.biomarker.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.dialect.Dialect;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Freedom Mukomana
 *
 */
@SuppressWarnings("deprecation")
@Transactional
@Repository("HibernateSessionDAO")
public abstract class HibernateSessionDAO {
	
	@Autowired
	private final SessionFactory sessionFactory;
	protected final Session session;
	private Dialect			dialect;
	
	

	public HibernateSessionDAO() {
		super();
		sessionFactory = new AnnotationConfiguration().configure()
				.buildSessionFactory();
				session = sessionFactory.openSession();
				System.out.println("Begin transaction...");
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		dialect = ((SessionFactoryImpl) sessionFactory).getDialect();
	}

	/**
	 * Return a Hibernate Session instance through the sessionFactory
	 * 
	 * @return
	 */
	public Session getSession() {
		if(sessionFactory!=null)
			return sessionFactory.getCurrentSession();
		else{
			System.err.println("SESSION FACTORY NULL");
			return null;
		}
	}
	
	/**
	 * Don't open a sessions without a finally closing it
	 * 
	 * @return
	 */
	public Session openSession() {
		if(sessionFactory!=null)
			return sessionFactory.openSession();
		else{
			System.err.println("SESSION FACTORY NULL on Attempt to open session");
			return null;
		}
	}
	
	public void closeSession(Session session) {
		session.close();
	}

	public Dialect getDialect() {
		if (dialect == null) {
			dialect = ((SessionFactoryImpl) sessionFactory).getDialect();
		}
		return dialect;
	}

	public StatelessSession getStatelessSession() {
		return sessionFactory.openStatelessSession();
	}

}
