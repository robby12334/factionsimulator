package com.factionsimulator.fs.data.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Magical_Items")
@Entity
@Table(name="MAGICAL_ITEMS")
public class Magical_Items {

	@Id
	@Column(name = "ITEM_NAME", length = 40, nullable = false)
	private String itemName;

	@Column(name = "ITEM_DESCRIPTION", length = 255, nullable = false)
	private String itemDescription;

	@Column(name = "ITEM_PURPOSE", length = 20, nullable = false)
	private String itemPurpose;

	@Column(name = "ITEM_COST", length = 20, nullable = false)
	private Integer itemCost;

	@Column(name = "ITEM_SUB_CLASS", length = 20, nullable = false)
	private String itemSubClass;

	@Column(name = "ITEM_RARITY", length = 20, nullable = false)
	private String itemRarity;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getItemPurpose() {
		return itemPurpose;
	}

	public void setItemPurpose(String itemPurpose) {
		this.itemPurpose = itemPurpose;
	}

	public Integer getItemCost() {
		return itemCost;
	}

	public void setItemCost(Integer itemCost) {
		this.itemCost = itemCost;
	}

	public String getItemSubClass() {
		return itemSubClass;
	}

	public void setItemSubClass(String itemSubClass) {
		this.itemSubClass = itemSubClass;
	}

	public String getItemRarity() {
		return itemRarity;
	}

	public void setItemRarity(String itemRarity) {
		this.itemRarity = itemRarity;
	}
}
