package arturro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.capgemini.enums.YesNo;

@Entity
@Table(name="projekty")
public class Projekt {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;	
	@Column(nullable = false, length = 100)
	private String nazwa;
	
//	@Column(name="kierownik_id")
//	private long idKierownika;
	@JoinColumn(name="kierownik_id")
	@ManyToOne
	private Pracownik kierownik;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "czy_zewnetrzny")
	private YesNo external;
	@Column
	private int wersja;
	
	public Projekt() {
		
	}
	
	public Projekt(String nazwa, Pracownik kierownik, YesNo external) {
		this(nazwa);
		this.kierownik = kierownik;
		this.external = external;
	}
	
	public Projekt(String nazwa) {
		this.nazwa = nazwa;
		wersja = 1;
	}

	
	public int getId() {
		return id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public Pracownik getKierownik() {
		return kierownik;
	}

	public void setKierownik(Pracownik kierownik) {
		this.kierownik = kierownik;
	}

	public YesNo getExternal() {
		return external;
	}

	public void setExternal(YesNo external) {
		this.external = external;
	}

	public int getWersja() {
		return wersja;
	}

	public void setWersja(int wersja) {
		this.wersja = wersja;
	}
}
