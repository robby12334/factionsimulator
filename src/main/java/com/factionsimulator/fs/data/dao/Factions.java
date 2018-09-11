package com.factionsimulator.fs.data.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Factions")
@Entity
@Table(name="FACTIONS")
public class Factions {

	@Id
	@Column(name = "FACTION_NAME", length = 30, nullable = false)
	private String factionName;

	@Column(name = "ACTIVE", length = 20, nullable = false)
	private Integer active;

	public String getFactionName() {
		return factionName;
	}

	public void setFactionName(String factionName) {
		this.factionName = factionName;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}
	
}
