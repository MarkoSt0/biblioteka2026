package biblioteka;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.ArrayList;
import java.util.List;
class KnjigaTest {

	private Knjiga k;

	@BeforeEach
	void setUp() {
		k = new Knjiga();
	}

	@Test
	void testSetNaslovValidan() {
		k.setNaslov("Prokleta avlija");
		assertEquals("Prokleta avlija", k.getNaslov());
	}

	@Test
	void testSetNaslovNull() {
		assertThrows(NullPointerException.class, () -> k.setNaslov(null));
	}

	@Test
	void testSetNaslovPrazan() {
		assertThrows(IllegalArgumentException.class, () -> k.setNaslov(""));
	}

	@Test
	void testSetIsbnValidan() {
		k.setIsbn(123456789L);
		assertEquals(123456789L, k.getIsbn());
	}

	@ParameterizedTest
	@CsvSource({ "0", "-1", "-100" })
	void testSetIsbnNevalidan(long isbn) {
		assertThrows(IllegalArgumentException.class, () -> k.setIsbn(isbn));
	}

	@Test
	void testSetIzdavacValidan() {
		k.setIzdavac("Laguna");
		assertEquals("Laguna", k.getIzdavac());
	}

	@Test
	void testSetIzdavacNull() {
		assertThrows(NullPointerException.class, () -> k.setIzdavac(null));
	}

	@Test
	void testSetIzdavacPrazan() {
		assertThrows(IllegalArgumentException.class, () -> k.setIzdavac(""));
	}

	@Test
	void testSetIzdanjeValidno() {
		k.setIzdanje(1);
		assertEquals(1, k.getIzdanje());
	}

	@Test
	void testSetIzdanjeNevalidno() {
		assertThrows(IllegalArgumentException.class, () -> k.setIzdanje(0));
	}

	@Test
	void testSetAutori() {
		List<Autor> autori = new ArrayList<>();
		autori.add(new Autor());
		k.setAutori(autori);
		
		assertNotNull(k.getAutori());
		assertEquals(1, k.getAutori().size());
	}

	@Test
	void testEqualsIstiObjekat() {
		k.setIsbn(123);
		assertTrue(k.equals(k));
	}

	@Test
	void testEqualsNull() {
		k.setIsbn(123);
		assertFalse(k.equals(null));
	}

	@Test
	void testEqualsDrugaKlasa() {
		k.setIsbn(123);
		assertFalse(k.equals("Neki String"));
	}

	@Test
	void testEqualsIstiIsbn() {
		k.setIsbn(123);
		Knjiga k2 = new Knjiga();
		k2.setIsbn(123);
		
		assertTrue(k.equals(k2));
		assertEquals(k.hashCode(), k2.hashCode());
	}

	@Test
	void testEqualsRazlicitiIsbn() {
		k.setIsbn(123);
		Knjiga k2 = new Knjiga();
		k2.setIsbn(456);
		
		assertFalse(k.equals(k2));
	}

	@Test
	void testToString() {
		k.setNaslov("Test");
		k.setIsbn(123);
		k.setIzdavac("Izdavac");
		k.setIzdanje(1);
		
		String s = k.toString();
		
		assertTrue(s.contains("Test"));
		assertTrue(s.contains("123"));
		assertTrue(s.contains("Izdavac"));
	}
}
