package test.resourses;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.Model.SccModel;

public class SccModelUnitTest {

	
	private SccModel model;

	@Before
	public void setUp() throws Exception {
	model = new SccModel();	
	model.initialize();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEncendido() {
		model.on();
		int esperado = 40;
		int obtenido = model.getTargetSpeed();
		assertEquals(esperado, obtenido);
	}

}
