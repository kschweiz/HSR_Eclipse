import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;



class TestHut implements IColor{

	@Test
	void testZylinderMitFeder() {
		Hut hut = new Zylinder(55);
		hut = new DekorateFeder(hut);
		hut = new DekorateGeschenkverpackung(hut);
		assertEquals(444.9, hut.getPrice());
	}
	
	@Test
	void testFedoraMitGeschenkPapier() {
		Hut hut = new Fedora(Color.BLUE,46);
		hut = new DekorateGeschenkverpackung(hut);
		assertEquals(359.9, hut.getPrice());
	}
	
	 @Rule
	  public ExpectedException exception = ExpectedException.none();

	  @Test
	  public void throwsIllegalArgumentException() {
	    exception.expect(IllegalArgumentException.class);
	    exception.expectMessage("Hut Gr�sse muss zwischen 45cm und 65cm sein!");
	    assertThrows(IllegalArgumentException.class, Hut hut = new Fedora(Color.BLUE,90));
	  }

	  //Tests m�ssen noch geschrieben werden!
	  //Test

}