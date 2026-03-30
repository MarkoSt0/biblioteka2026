package biblioteka;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutorTest {
	Autor a;
	@BeforeEach
	void setUp() throws Exception {
		a = new Autor();
	}

	@AfterEach
	void tearDown() throws Exception {
		a = null;
	}

	@Test
	void testHashCode() {
		a.setIme("Pera");
		a.setPrezime("Peric");
		Autor a2 = new Autor("Pera", "Peric");
		Autor a3 = new Autor("mika", "Peric");
		assertEquals(a.hashCode(), a2.hashCode());
		assertNotEquals(a.hashCode(), a3.hashCode());
	}

	@Test
	void testAutor() {
		assertNotNull(new Autor());
	}

	@Test
	void testAutorStringString() {
		Autor a = new Autor("Pera", "Peric");
		assertNotNull(a);
		assertEquals("Pera", a.getIme());
		assertEquals("Peric", a.getPrezime());
	}

	@Test
	void testSetIme() {
		a.setIme("Pera");
		assertEquals("Pera", a.getIme());
	}
	
	@Test
	void testSetImeNull() {
		assertThrows(RuntimeException.class, () -> a.setIme(null));
	}

	@Test
	void testSetImeEmpty() {
		assertThrows(IllegalArgumentException.class, () -> a.setIme(""));
	}
	
	@Test
	void testSetPrezime() {
		a.setPrezime("Pera");
		assertEquals("Pera", a.getPrezime());
	}
	
	@Test
	void testSetPrezimeNull() {
		assertThrows(RuntimeException.class, () -> a.setPrezime(null));
	}

	@Test
	void testSetPrezimeEmpty() {
		Exception e = assertThrows(IllegalArgumentException.class, () -> a.setPrezime(""));
		assertEquals("Prezime ne sme biti prazno", e.getMessage());
	}

	@Test
	void testToString() {
		a.setIme("Laza");
		a.setPrezime("Lazarevic");
		assertTrue(a.toString().contains("Laza"));
		assertTrue(a.toString().contains("Lazarevic"));
	}

	@ParameterizedTest
	@CsvSource({
		"Pera, Peric, Pera, Peric, true",
		"Pera, Peric, Pera, Mikic, false",
		"Pera, Peric, Mika, Peric, false",
		"Pera, Peric, Mika, Mikic, false",
	})
	@DisplayName("Testovi za equals metodu")
	void testEqualsObject(String ime1, String prezime1, String ime2, String prezime2, boolean jednako) {
		a.setIme(ime1); a.setPrezime(prezime1);
		Autor b = new Autor(ime2, prezime2);
		assertEquals(jednako, a.equals(b));
	}
	
	@Test
	void testEqualsObjectNull() {
		assertFalse(a.equals(null));
	}
	
	@Test
	void testEqualsObjectNullDruga() {
		assertFalse(a.equals(new String()));
	}

}
