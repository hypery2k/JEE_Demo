package de.martinreinhardt.jee.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.martinreinhardt.jee.domain.ElectricProduct;
import de.martinreinhardt.jee.domain.GardeningProduct;
import de.martinreinhardt.jee.domain.JoinSuperProduct;
import de.martinreinhardt.jee.util.EmHelper;
import de.martinreinhardt.jee.util.JPAHelper;
import static org.junit.Assert.*;

public class InheritanceJoinedTest extends JPAHelper {

	// Logging object
	private static final Logger LOG = LoggerFactory
	                                    .getLogger(InheritanceJoinedTest.class);

	@Test
	public final void testPositive() throws Exception {
		EmHelper.execute(new EmHelper.Runnable() {

			@Override
			public void execute(final EntityManager em) throws Exception {

				// create products
				ElectricProduct elProduct = new ElectricProduct();
				elProduct.setName("shaver");
				elProduct.setVoltage(12);
				GardeningProduct gaProduct = new GardeningProduct();
				gaProduct.setName("hammer");
				gaProduct.setWeight(2);
				// persist data
				em.persist(gaProduct);
				em.persist(elProduct);

				assertTrue("Gardening product should be persisted, but PK was 0!", gaProduct.getId() > 0);
				assertTrue("Electric product should be persisted, but PK was 0!", elProduct.getId() > 0);
				
				final CriteriaQuery<JoinSuperProduct> cq = em
				    .getCriteriaBuilder().createQuery(
				        JoinSuperProduct.class);
				cq.select(cq.from(JoinSuperProduct.class));
				List<JoinSuperProduct> products = em.createQuery(cq)
				    .getResultList();
				assertTrue("Products should not be empty", products.size() > 0);
				LOG.info("Got the following products:" + products);
			}
		}, em);
	}

}
