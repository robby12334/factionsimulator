package com.factionsimulator.fs.data.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Character")
@Entity
@Table(name="CHARACTER")
public class Character {
	
	@Id
	@Column(name = "CHARACTER_ID", nullable = false)
	String characterId;
	
	@Column(name = "FIRST_NAME", length = 20, nullable = false)
	String firstName;
	
	@Column(name = "LAST_NAME", length = 20, nullable = false)
	String lastName;
	
	@Column(name = "CLASS_NAME", length = 20, nullable = false)
	String className;
	
	@Column(name = "CLASS_LEVEL", nullable = false)
	Integer classLevel;
	
	@Column(name = "HIT_POINTS", nullable = false)
	Integer hitPoints;
	
	@Column(name = "FACTION_NAME", length = 20, nullable = false)
	String factionName;

	public Character() {
		
	}
	
	public String getCharacterId() {
		return characterId;
	}

	public void setCharacterId(String characterId) {
		this.characterId = characterId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getClassLevel() {
		return classLevel;
	}

	public void setClassLevel(Integer classLevel) {
		this.classLevel = classLevel;
	}

	public Integer getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(Integer hitPoints) {
		this.hitPoints = hitPoints;
	}

	public String getFactionName() {
		return factionName;
	}

	public void setFactionName(String factionName) {
		this.factionName = factionName;
	}
	
}
