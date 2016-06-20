package test.java;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import main.java.Class.Regulador;
import main.java.Model.TemplateMethod.Estandar;
import main.java.Model.TemplateMethod.SccModel;

public class SccModelUnitTest {
	
	SccModel model;

	@Before
	public void setUp() throws Exception {
		model = new Estandar();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testOn() {
		model.on();
		assertTrue("No se mueve",model.getSpeed()>0);
		assertEquals("No se colocó velocidad objetivo",model.getTargetSpeed(),40);
		try {
			Thread.sleep(5000);
			assertEquals("No llegó a la velocidad de inicio",40,model.getSpeed());
		} catch (InterruptedException e) {
			fail();
		}
	}

	@Test
	public void testOff() {
		try {
			model.on();
			Thread.sleep(1000);
			model.off();
			assertEquals("No se cambió velocidad a 0",0,model.getTargetSpeed());
			assertTrue("El Regulador se apagó antes de frenar.",model.getRegulador().isRunning());
			Thread.sleep(1100);
			assertEquals(0,model.getSpeed());
			assertFalse("El Regulador no se apagó.",model.getRegulador().isRunning());
		} catch (InterruptedException e) {
			fail();
		}
	}

	@Test
	public void testPause() {
		try{
			model.on();
			Thread.sleep(1000);
			model.pause();
			assertEquals("No se puso velocidad a 0.",0,model.getTargetSpeed());
			Thread.sleep(1100);
			assertEquals("No se detuvo.",0,model.getSpeed());
			assertTrue("Se borro el registro de metros reccoridos",model.getMetros()>0);
			assertTrue("No se debe apagar el Regulador",model.getRegulador().isRunning());
		}catch (InterruptedException e) {
			fail();
		}
	}

	@Test
	public void testResume() {
		try{
			model.on();
			Thread.sleep(1000);
			model.pause();
			Thread.sleep(1500);
			model.resume();
			
		}catch (InterruptedException e) {
			fail();
		}
	}

	
	@Test
	public void testSetSpeed() {
		model.on();
		model.setSpeed(60);
		assertEquals(60,model.getTargetSpeed());
		assertNotEquals(60,model.getSpeed());
	}

	@Test
	public void testModifyCurrentSpeed() {
		model.on();
		model.setSpeed(10);
		try {
			Thread.sleep(1000);
			assertEquals(model.getSpeed(),10);
			model.modifyCurrentSpeed(10);
			assertTrue(model.getSpeed()>=19);
			assertTrue(model.getSpeed()<=20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	@Test
	public void testGetSpeed() {
		model.on();
		model.setSpeed(5);
		try{
			Thread.sleep(1000);
			assertEquals("Velocidad incorrecta.",5, model.getSpeed());
			model.setSpeed(20);
			assertNotEquals("El cambio de velocidad no debe ser inmediato.",20, model.getSpeed());

		}catch(InterruptedException e){
			fail();
		}

	}

	@Test
	public void testGetTargetSpeed() {
		model.on();
		model.setSpeed(20);
		assertEquals(20, model.getTargetSpeed());
	}

	@Test
	public void testGetMetros() {
		model.on();
		assertEquals(0,(long)model.getMetros());
		try {
			Thread.sleep(5000);
			assertTrue(model.getMetros()>1);
		} catch (InterruptedException e) {
			fail();
		}
		
		
	}
	

	@Test
	public void testGetRegulador() {
		model.on();
		try{
			Regulador reg = model.getRegulador();
		}catch (NullPointerException e){
			fail("No se obtuvo el Regulador");
		}
	}

}