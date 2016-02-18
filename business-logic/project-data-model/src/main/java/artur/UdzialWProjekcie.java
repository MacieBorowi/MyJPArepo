package artur;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="projekty_udzialy")
@IdClass(UdzialWProjekcieId.class)
public class UdzialWProjekcie {

	@Id
	@Column(name = "projekt_id", nullable = false)
	private int idProjektu;
	@Id
	@Column(name = "pracownik_id", nullable = false)
	private int idPracownika;
	@Id
	@Column(name = "data_od", nullable = false)
	private Date dataOd;

	@Enumerated(EnumType.STRING)
	@Column
	private ProjectFunctions funkcja;
	@Column
	private BigDecimal wynagrodzenie;
	@Column(name = "data_do")
	private Date dataDo;
	@Column
	private int wersja;
	
	public UdzialWProjekcie() {
		
	}
	
	public UdzialWProjekcie(int idProjektu, int idPracownika, Date dataOd) {
		this.idProjektu = idProjektu;
		this.idPracownika = idPracownika;
		this.dataOd = dataOd;
		wersja = 1;
		setWynagrodzenie("0");
	}

	public int getIdProjektu() {
		return idProjektu;
	}
	public int getIdPracownika() {
		return idPracownika;
	}
	public Date getDataOd() {
		return dataOd;
	}
	public ProjectFunctions getFunkcja() {
		return funkcja;
	}
	public void setFunkcja(ProjectFunctions funkcja) {
		this.funkcja = funkcja;
	}
	public BigDecimal getWynagrodzenie() {
		return wynagrodzenie;
	}
	public void setWynagrodzenie(String wynagrodzenie) {
		this.wynagrodzenie = new BigDecimal(wynagrodzenie);
		this.wynagrodzenie.setScale(-2, BigDecimal.ROUND_HALF_UP);
	}
	public void setWynagrodzenie(BigDecimal wynagrodzenie) {
		this.wynagrodzenie = wynagrodzenie;
		this.wynagrodzenie.setScale(-2, BigDecimal.ROUND_HALF_UP);
	}
	public Date getDataDo() {
		return dataDo;
	}
	public void setDataDo(Date dataDo) {
		this.dataDo = dataDo;
	}
	public int getWersja() {
		return wersja;
	}
	public void setWersja(int wersja) {
		this.wersja = wersja;
	}
}
