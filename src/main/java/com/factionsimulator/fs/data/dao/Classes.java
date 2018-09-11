package com.factionsimulator.fs.data.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Classes")
@Entity
@Table(name="CLASSES")
public class Classes {

	@Id
	@Column(name = "CLASS_NAME", length = 20, nullable = false)
	private String className;
	
	@Column(name = "HIT_DIE")
	private Integer hitDie;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getHitDie() {
		return hitDie;
	}

	public void setHitDie(Integer hitDie) {
		this.hitDie = hitDie;
	}
	
}
