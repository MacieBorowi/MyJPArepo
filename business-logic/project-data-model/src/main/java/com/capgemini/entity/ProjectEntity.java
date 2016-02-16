package com.capgemini.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.capgemini.enums.YesNo;

@Entity
@Table(name = "projects")
public class ProjectEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable= true, length = 2)
	private YesNo external;

	//bi-directional many-to-one association to EmploeeEntity
//	@ManyToOne
//	@JoinColumn(name="manager")
//	@Column(nullable= true)
//	private EmploeeEntity manager;
	
	public ProjectEntity() {
	}
	
	public ProjectEntity(String name, YesNo external) {
		this.name = name;
		this.external = external;
	}
	
	public ProjectEntity(String name, EmploeeEntity manager, YesNo external) {
		this.name = name;
//		this.manager = manager;
		this.external = external;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public YesNo getExternal() {
		return external;
	}

	public void setExternal(YesNo external) {
		this.external = external;
	}

	public EmploeeEntity getManager() {
//		return manager;
		return null;
	}

	public void setManager(EmploeeEntity manager) {
//		this.manager = manager;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		ProjectEntity other = (ProjectEntity) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	



	
	
}
