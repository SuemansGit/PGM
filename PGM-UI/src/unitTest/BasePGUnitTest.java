package unitTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.pga.dao.AccountDAO;

public class BasePGUnitTest {
	protected EntityManagerFactory factory = null;
	protected EntityManager em = null;
	EntityTransaction entr = null;
		public BasePGUnitTest() {
			factory = Persistence.createEntityManagerFactory("pgajpa");
			em = factory.createEntityManager();
			entr = em.getTransaction();
		}
 
		protected  void setUp(){
			entr.begin();
		}
	}

