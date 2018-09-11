package com.factionsimulator.fs.data.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Character_Items")
@Entity
@Table(name = "CHARACTER_ITEMS")
@IdClass(CharacterItemsId.class)
public class Character_Items {

	@Id
	@Column(name = "ITEM_NAME", length = 20, nullable = false)
	private String className;

	@Column(name = "NUMBER_OF_ITEM", nullable = false)
	private Integer numberOfItem;

	@Id
	@Column(name = "CHARACTER_ID", nullable = false)
	private Integer characterId;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getNumberOfItem() {
		return numberOfItem;
	}

	public void setNumberOfItem(Integer numberOfItem) {
		this.numberOfItem = numberOfItem;
	}

	public Integer getCharacterId() {
		return characterId;
	}

	public void setCharacterId(Integer characterId) {
		this.characterId = characterId;
	}
}
