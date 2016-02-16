package arturro;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="pracownicy")
public class Pracownik {

	@Id
	private long PESEL;
	@Column(nullable = false, length = 40)
	private String imie;
	@Column(nullable = false, length = 50)
	private String nazwisko;
	@Temporal(TemporalType.DATE)			//do BD przekazuje tylko datę, a nie godzinę
	@Column(name = "data_ur")
	private Date dataUrodzenia;
//	@Column(name = "dzial_id")
//	private int idDzialu;	//		<-- tego nie używać, zamiast tego robimy poniższą relację:
	@JoinColumn(name="dzial_id")
	@ManyToOne
	private Dzial dzial;
	
	@Column
	private int wersja;
	
	
	
	public Pracownik() {	
	}
	
	public Pracownik(String imie, String nazwisko, long PESEL) {
		this.PESEL = PESEL;
		this.imie = imie;
		this.nazwisko = nazwisko;
		long datePart = PESEL / 100000;
		int day = (int)(datePart % 100);
		datePart /= 100;
		int year = (int)(datePart / 100);
		datePart = datePart % 100;
		if (datePart > 20) {
			datePart -= 20;
			year += 100;
		}
		GregorianCalendar gcalendar = new GregorianCalendar(year+1900, (int)datePart-1, day);
		dataUrodzenia = gcalendar.getTime();
		wersja = 1;
	}

	public long getPESEL() {
		return PESEL;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public Date getDataUrodzenia() {
		return dataUrodzenia;
	}

	public Dzial getIdDzialu() {
		return dzial;
	}

	public void setDzial(Dzial dzial) {
		this.dzial = dzial;
	}

	public int getWersja() {
		return wersja;
	}

	public void setWersja(int wersja) {
		this.wersja = wersja;
	}
	
}
