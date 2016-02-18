package artur;

import java.io.Serializable;
import java.util.Date;


public class UdzialWProjekcieId implements Serializable{
	private int idProjektu;
	private int idPracownika;
	private Date dataOd;
	
	public UdzialWProjekcieId() {
		super();
	}

	public UdzialWProjekcieId(int idProjektu, int idPracownika, Date dataOd) {
		super();
		this.idProjektu = idProjektu;
		this.idPracownika = idPracownika;
		this.dataOd = dataOd;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataOd == null) ? 0 : dataOd.hashCode());
		result = prime * result + idPracownika;
		result = prime * result + idProjektu;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UdzialWProjekcieId other = (UdzialWProjekcieId) obj;
		if (dataOd == null) {
			if (other.dataOd != null)
				return false;
		} else if (!dataOd.equals(other.dataOd))
			return false;
		if (idPracownika != other.idPracownika)
			return false;
		if (idProjektu != other.idProjektu)
			return false;
		return true;
	}
}
