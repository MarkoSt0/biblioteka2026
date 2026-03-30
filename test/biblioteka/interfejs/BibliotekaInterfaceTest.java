package biblioteka.interfejs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import biblioteka.Knjiga;

public abstract class BibliotekaInterfaceTest {
	
	BibliotekaInterface b;
	Knjiga k;
	Knjiga k2;
	Knjiga k3;
	
	public abstract BibliotekaInterface getInstance();

	@BeforeEach
	void setUp() throws Exception {
		b = getInstance();
		k = new Knjiga();
		k.setIsbn(123);
		k2 = new Knjiga();
		k2.setIsbn(456);
		k3 = new Knjiga();
		k3.setIsbn(999);
	}

	@AfterEach
	void tearDown() throws Exception {
		b = null;
	}

	@Test
	void testDodajKnjiguNull() {
		assertThrows(NullPointerException.class, () -> b.dodajKnjigu(null));
	}
	
	@Test
	void testDodajKnjiguDuplikat() {
		b.dodajKnjigu(k);
		k2.setIsbn(123);
		assertThrows(IllegalArgumentException.class, () -> b.dodajKnjigu(k2));
	}
	
	@Test
	void testDodajKnjigu() {
		b.dodajKnjigu(k);
		b.dodajKnjigu(k2);
		List<Knjiga> knjige = b.vratiSveKnjige();
		assertTrue(knjige.contains(k));
		assertTrue(knjige.contains(k2));
		assertTrue(knjige.size() == 2);
	}
	
	@Test
	void testObrisiKnjiguNull() {
		assertThrows(NullPointerException.class, () -> b.obrisiKnjigu(null));
	}
	
	@Test
	void testObrisiKnjiguNePostoji() {
		b.dodajKnjigu(k);
		b.dodajKnjigu(k2);
		assertThrows(IllegalArgumentException.class, () -> b.obrisiKnjigu(k3));
	}

	@Test
	void testObrisiKnjigu() {
		b.dodajKnjigu(k);
		b.dodajKnjigu(k2);
		b.dodajKnjigu(k3);
		b.obrisiKnjigu(k2);
		List<Knjiga> knjige = b.vratiSveKnjige();
		assertTrue(knjige.contains(k));
		assertFalse(knjige.contains(k2));
		assertTrue(knjige.contains(k3));
		assertTrue(knjige.size() == 2);
	}

	@Test
	void testPronadjiKnjiguSveNull() {
		assertThrows(IllegalArgumentException.class, () -> b.pronadjiKnjigu(null, 0, null, null));
	}
	
	@Test
	void testPronadjiKnjiguPrazno() {
		k.setNaslov("Knjiga 1");
		k2.setNaslov("Knjiga 2");
		k3.setNaslov("Knjiga 3");
		
		b.dodajKnjigu(k);
		b.dodajKnjigu(k2);
		b.dodajKnjigu(k3);
		
		List<Knjiga> knjige = b.pronadjiKnjigu(null, 0, "Gospodar", null);
		assertEquals(0, knjige.size());
	}
	
	@Test
	void testPronadjiKnjiguJednaKnjiga() {
		k.setNaslov("Knjiga 1");
		k2.setNaslov("Gospodar Prstenova");
		k3.setNaslov("Knjiga 3");
		
		b.dodajKnjigu(k);
		b.dodajKnjigu(k2);
		b.dodajKnjigu(k3);
		
		List<Knjiga> knjige = b.pronadjiKnjigu(null, 0, "gospodar", null);
		assertEquals(1, knjige.size());
		assertTrue(knjige.contains(k2));
	}
	
	@Test
	void testPronadjiKnjiguViseKnjiga() {
		k.setNaslov("Knjiga 1");
		k2.setNaslov("Gospodar Prstenova");
		k3.setNaslov("GOSPODAR PRSTENOVA");
		
		b.dodajKnjigu(k);
		b.dodajKnjigu(k2);
		b.dodajKnjigu(k3);
		
		List<Knjiga> knjige = b.pronadjiKnjigu(null, 0, "gospodar", null);
		assertEquals(2, knjige.size());
		assertTrue(knjige.contains(k2));
		assertTrue(knjige.contains(k3));
	}

}
