package test.java;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.Controller.ControllerInterface;
import main.java.Controller.SccController;
import main.java.Model.SccModel;
import main.java.Model.SccModelInterface;
import main.java.View.SccView;

public class SccViewUnitTest {

	

	SccModel model;
	SccController cont;
	SccView view;
	@Before
	public void setUp() throws Exception {
		try{
			model = new SccModel();
			cont = new SccController(model, true);		
			view = cont.getSccView();
			model.on();
			model.setSpeed(5);
		}catch(NullPointerException e){
			fail();
		}
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInicializa() {
		fail("Not yet implemented");
		
	}

	@Test
	public void testUpdateBeat() {
		
		
	}

	@Test
	public void testUpdateBPM() {
		try {
			Thread.sleep(1000);
			assertEquals(5,view.vel.getText());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testStartAnimation() {
		fail("Not yet implemented");
	}

	@Test
	public void testStopAnimation() {
		fail("Not yet implemented");
	}

	@Test
	public void testEnableStopMenuItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testDisableStopMenuItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testEnableStartMenuItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testDisableStartMenuItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testDisablePauseButtonItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testEnablePauseButtonItem() {
		fail("Not yet implemented");
	}

}
