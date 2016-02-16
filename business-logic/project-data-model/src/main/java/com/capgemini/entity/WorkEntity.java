package com.capgemini.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.capgemini.enums.Position;

@Entity
@Table(name = "worklist"
//, uniqueConstraints =  @UniqueConstraint(name = "uniquepojectName", columnNames = {"startDate"})
)
public class WorkEntity{
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable = true)
	@Enumerated(EnumType.STRING)
	private Position position;

	@Column(nullable = true, precision =10 , scale=2 )
	private  BigDecimal salary;

	@JoinColumn(name="projectentity_id")
	@ManyToOne
	private ProjectEntity pojectName;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = true)
	private Date endDate;
	
	@ManyToOne
	private EmploeeEntity emploee;

	public WorkEntity(){
	}
	
	public WorkEntity( EmploeeEntity emploee, ProjectEntity pojectName, Date startDate,
			Date endDate, Position position, BigDecimal salary) {
		this.emploee = emploee;
		this.pojectName = pojectName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.position = position;
		this.salary = salary;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public ProjectEntity getpojectName() {
		return pojectName;
	}

	public void setpojectName(ProjectEntity pojectName) {
		this.pojectName = pojectName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public EmploeeEntity getEmploee() {
		return emploee;
	}

	public void setEmploee(EmploeeEntity emploee) {
		this.emploee = emploee;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		WorkEntity other = (WorkEntity) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
	
}
