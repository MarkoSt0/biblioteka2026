package biblioteka;

import java.util.List;
import java.util.Objects;

/**
 * Predstavlja knjigu u biblioteci.
 * * Svaka knjiga ima svoj naslov, jedinstveni ISBN broj, listu autora,
 * izdavača i broj izdanja.
 * * @author Marko Stevic
 * @version 1.0
 */
public class Knjiga {
	
	/**
	 * Naslov knjige kao String.
	 */
	private String naslov;
	
	/**
	 * Jedinstveni ISBN broj knjige.
	 */
	private long isbn;
	
	/**
	 * Lista autora koji su napisali knjigu.
	 */
	private List<Autor> autori;
	
	/**
	 * Naziv izdavača knjige.
	 */
	private String izdavac;
	
	/**
	 * Redni broj izdanja knjige.
	 */
	private int izdanje;
	
	/**
	 * Vraća naslov knjige.
	 * * @return Naslov knjige kao String.
	 */
	public String getNaslov() {
		return naslov;
	}
	
	/**
	 * Postavlja naslov knjige na unetu vrednost.
	 * * @param naslov Novi naslov knjige.
	 * @throws java.lang.NullPointerException Ako je uneti naslov null.
	 * @throws java.lang.IllegalArgumentException Ako je uneti naslov prazan String.
	 */
	public void setNaslov(String naslov) {
		if(naslov == null) throw new NullPointerException("Naslov ne sme biti null");
		if(naslov.isEmpty()) throw new IllegalArgumentException("Naslov ne sme biti prazan");
		this.naslov = naslov;
	}
	
	/**
	 * Vraća ISBN broj knjige.
	 * * @return ISBN broj kao long.
	 */
	public long getIsbn() {
		return isbn;
	}
	
	/**
	 * Postavlja ISBN broj knjige.
	 * * @param isbn Novi ISBN broj.
	 * @throws java.lang.IllegalArgumentException Ako je ISBN broj manji od ili jednak nuli.
	 */
	public void setIsbn(long isbn) {
		if(isbn <= 0) throw new IllegalArgumentException("ISBN mora biti veci od nule");
		this.isbn = isbn;
	}
	
	/**
	 * Vraća listu autora knjige.
	 * * @return Lista objekata klase Autor.
	 */
	public List<Autor> getAutori() {
		return autori;
	}
	
	/**
	 * Postavlja listu autora knjige.
	 * * @param autori Lista autora koji su radili na knjizi.
	 */
	public void setAutori(List<Autor> autori) {
		this.autori = autori;
	}
	
	/**
	 * Vraća naziv izdavača.
	 * * @return Izdavač kao String.
	 */
	public String getIzdavac() {
		return izdavac;
	}
	
	/**
	 * Postavlja naziv izdavača.
	 * * @param izdavac Novi naziv izdavača.
	 * @throws java.lang.NullPointerException Ako je uneti izdavač null.
	 * @throws java.lang.IllegalArgumentException Ako je uneti izdavač prazan String.
	 */
	public void setIzdavac(String izdavac) {
		if(izdavac == null) throw new NullPointerException("Izdavac ne sme biti null");
		if(izdavac.isEmpty()) throw new IllegalArgumentException("Izdavac ne sme biti prazan");
		this.izdavac = izdavac;
	}
	
	/**
	 * Vraća broj izdanja knjige.
	 * * @return Redni broj izdanja kao int.
	 */
	public int getIzdanje() {
		return izdanje;
	}
	
	/**
	 * Postavlja broj izdanja knjige.
	 * * @param izdanje Novo izdanje knjige.
	 * @throws java.lang.IllegalArgumentException Ako je broj izdanja manji od ili jednak nuli.
	 */
	public void setIzdanje(int izdanje) {
		if(izdanje <= 0) throw new IllegalArgumentException("Izdanje mora biti vece od nule");
		this.izdanje = izdanje;
	}

	/**
	 * Vraća String sa svim podacima o knjizi.
	 * * @return Svi podaci o knjizi (naslov, isbn, autori, izdavač, izdanje) u tekstualnom formatu.
	 */
	@Override
	public String toString() {
		return "Knjiga [naslov=" + naslov + ", isbn=" + isbn + ", autori=" + autori + ", izdavac=" + izdavac
				+ ", izdanje=" + izdanje + "]";
	}

	/**
	 * Generiše hash code na osnovu ISBN broja.
	 * * @return Hash code vrednost knjige.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}

	/**
	 * Poredi dve knjige prema ISBN broju.
	 * * @param obj Druga knjiga sa kojom se vrši poređenje.
	 * @return 
	 * <ul>
	 * <li><b>true</b> - ako su objekti isti, ili imaju isti ISBN broj.</li>
	 * <li><b>false</b> - ako je uneti objekat null, nije klase Knjiga, ili ima različit ISBN.</li>
	 * </ul>
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Knjiga other = (Knjiga) obj;
		return isbn == other.isbn;
	}
	
}