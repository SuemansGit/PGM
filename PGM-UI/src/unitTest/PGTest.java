package unitTest;

import javax.persistence.EntityTransaction;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.pga.dao.PgDAO;
import com.pga.eo.BedEO;
import com.pga.eo.PgEO;
import com.pga.eo.RoomEO;
import com.pga.ro.PgRO;

public class PGTest extends BasePGUnitTest{
	
	@Before
	@Override
	public void setUp(){
		super.setUp();
	}
	
	@After
	public void cleanUpData(){

		try {
			entr.commit();
		} finally {
			em.close();
			factory.close();
		}
		}
	
	@Test
	public void   createPg() {
		
		PgEO actual = new PgEO();
		actual.setName("test");
		actual.setAddress("test");
		em.persist(actual);
		em.flush();
		
		PgRO expected = PgDAO.getPgById(em, actual.getPgId());
//		Assert.assertEquals(expected.getAddress(), actual.getAddress());
		Assert.assertEquals("test", actual.getName());
		
		}
	@Test
	public void createBed(){
		BedEO b = new BedEO();
		b.getPriceList();
		
	}
	@Test
	public void createRoom()
	{
		RoomEO actual = new RoomEO();
		actual.setName("test");
		em.persist(actual);
		em.flush();
		
	}
}
