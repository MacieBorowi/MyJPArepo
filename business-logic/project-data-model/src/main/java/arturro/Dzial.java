package arturro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dzialy")
public class Dzial {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;	
	@Column(nullable = false, length = 60)
	private String nazwa;
	@Column
	private int wersja;
	
	public Dzial() {
		wersja = 1;
	}	
	
	public Dzial(String nazwa) {
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

	public int getWersja() {
		return wersja;
	}

	public void setWersja(int wersja) {
		this.wersja = wersja;
	}	
}
