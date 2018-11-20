import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestHut implements IColor{

	@Test
	public void testZylinderMitGeschenkPapier() {
		Hut hut = new Zylinder(55);
		hut = new DekorateGeschenkverpackung(hut);
		assertEquals(409.9, hut.getPrice());
	}
	
	@Test
	public void testFedoraMitGeschenkPapier() {
		Hut hut = new Fedora(Color.BLUE,46);
		hut = new DekorateGeschenkverpackung(hut);
		assertEquals(359.9, hut.getPrice());
	}
	
	@Test
	public void testModischerHut() {
		Hut hut = new ModischerSchlapphut(Color.GREEN, 45);
		hut = new DekorateFeder(hut);
		hut = new DekorateGeschenkverpackung(hut);
		assertEquals(244.9, hut.getPrice());
	}
	
	@Test
	public void testThrowsIllegalArgumentExceptionSizeGross() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Fedora(Color.BLUE,90);
	    });
	}
	
	@Test
	public void testThrowsIllegalArgumentExceptionSizeKlein() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Fedora(Color.BLUE,44);
	    });
	}
	
	@Test
	public void testThrowsIllegalARgumentExceptionZylinderMitFeder() {
		assertThrows(IllegalArgumentException.class, () -> {
			new DekorateFeder(new Zylinder(50));
			
	    });
	}
	


}
