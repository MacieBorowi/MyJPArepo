package com.capgemini.entity;

import java.util.Date;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "emploees")
public class EmploeeEntity {
	@Id
	@Column(nullable = false, length = 11)
	private String pesel;

	@Column(nullable = false, length = 45)
	private String name;

	@Column(nullable = false, length = 45)
	private String surname;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date bornDate;

	// bi-directional many-to-one association to DepartmentEntity
	@JoinColumn(name="departmententity_id")
	@ManyToOne
	private DepartmentEntity department;

	// bi-directional many-to-one association to WorkEntity
	@OneToMany(mappedBy = "emploee")
	private List<WorkEntity> workList;

	public EmploeeEntity() {
	}
	
	public EmploeeEntity(String name, String surname, Date bornDate, String pesel, DepartmentEntity department) {
		this.name = name;
		this.surname = surname;
		this.bornDate = bornDate;
		this.pesel = pesel;
		this.department = department;
	}
	
	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBornDate() {
		return bornDate;
	}

	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}

	public List<WorkEntity> getWorkList() {
		return workList;

	}

	public void setWorkList(List<WorkEntity> workList) {
		this.workList = workList;
	}
	
	public WorkEntity addWork(WorkEntity work) {
		getWorkList().add(work);
		work.setEmploee(this);

		return work;
	}

	public WorkEntity removeWork(WorkEntity work) {
		getWorkList().remove(work);
		work.setEmploee(null);

		return work;
	}	
	
	public DepartmentEntity getDepartment() {
		return department;
	}
	
	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pesel == null) ? 0 : pesel.hashCode());
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
		EmploeeEntity other = (EmploeeEntity) obj;
		if (pesel == null) {
			if (other.pesel != null)
				return false;
		} else if (!pesel.equals(other.pesel))
			return false;
		return true;
	}

	
	
}
