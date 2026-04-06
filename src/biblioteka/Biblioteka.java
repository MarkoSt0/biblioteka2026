package biblioteka;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import biblioteka.interfejs.BibliotekaInterface;

/**
 * Implementira BibliotekaInterfejs preko interne liste sa knjigama
 * @author Marko Stevic
 *
 */
public class Biblioteka implements BibliotekaInterface {
	
	private List<Knjiga> knjige = new ArrayList<>();
	

	@Override
	public void dodajKnjigu(Knjiga knjiga) {
		if(knjiga == null) 
			throw new NullPointerException("Knjiga ne sme biti null");
		if(knjige.contains(knjiga))
			throw new IllegalArgumentException("Knjiga vec postoji");
		knjige.add(knjiga);
	}

	@Override
	public void obrisiKnjigu(Knjiga knjiga) {
		if(knjiga == null) 
			throw new NullPointerException("Knjiga ne sme biti null");
		if(!knjige.contains(knjiga))
			throw new IllegalArgumentException("Knjiga ne postoji");
		knjige.remove(knjiga);
	}

	@Override
	public List<Knjiga> vratiSveKnjige() {
		return knjige;
	}

	/**
	 * Pretrazuje biblioteku i vraca sve knjige koje imaju uneti deo naslova.
	 * 
	 * Implementirana je pretraga <b>samo preko naslova</b>, a ne preko ostalih kriterijuma
	 * 
	 * @param autor Jedan od autora knjige.
	 * @param isbn tacan isbn broj knjige.
	 * @param naslov Deo naslova knjige. Ne mora se unositi ceo naslov.
	 * @param izdavac Deo naziva izdavaca. Ne mora se unositi ceo naziv.
	 * @return Lista sa svim knjigama koje odgovaraju kriterijumima ili praznu listu ako nijedna knjiga
	 * ne odgovara.
	 * @throws java.lang.IllegalArgumentException ako nije unet nijedan kriterijum pretrage,
	 * odnosno ako su svi null/nula.
	 */
	@Override
	public List<Knjiga> pronadjiKnjigu(Autor autor, long isbn, String naslov, String izdavac) {
		if(autor == null && isbn <= 0 && naslov == null && izdavac == null)
			throw new IllegalArgumentException("Morate uneti bar neki kriterijum pretrage");

		List<Knjiga> rezultati = new ArrayList<>();
		for (Knjiga k : knjige) {
			if(k.getNaslov().toUpperCase().contains(naslov.toUpperCase()))
				rezultati.add(k);
		}
		return rezultati;
	}

}
