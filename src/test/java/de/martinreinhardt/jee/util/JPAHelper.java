package de.martinreinhardt.jee.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Common base for all JPA related tests. This class inits the persistence
 * framework. JPAHelper based tests works only with pure DAO-Beans, for business
 * ejb, e.g. UserManager use integration tests
 * 
 * @author mreinhardt
 */
public class JPAHelper {

	// Logging object
	private static final Logger LOG = LoggerFactory.getLogger(JPAHelper.class);

	protected static EntityManagerFactory emf;

	protected static EntityManager em;

	/**
	 * Set up entity maneger and factory
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public static void setup() throws Exception {
		// Get the entity manager for the tests.
		emf = Persistence.createEntityManagerFactory("EJBTest");
		em = emf.createEntityManager();

	}

}
