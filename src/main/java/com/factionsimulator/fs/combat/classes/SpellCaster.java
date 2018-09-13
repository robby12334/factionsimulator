package com.factionsimulator.fs.combat.classes;

import java.util.ArrayList;

import com.factionsimulator.fs.data.dao.Character;

public class SpellCaster extends Combatant {

	private Integer spellOne = 0;
	private Integer spellTwo = 0;
	private Integer spellThree = 0;
	private Integer spellFour = 0;
	private Integer spellFive = 0;
	private Integer spellSix = 0;
	private Integer spellSeven = 0;
	private Integer spellEight = 0;
	private Integer spellNine = 0;
	private ArrayList<Integer> spellList;

	public SpellCaster(Character character) {
		super(character);
		setUpSpellSlots();
		setUpSpellList();
	}

	private void setUpSpellSlots() {
		switch (getLevel()) {
		case 1:
			spellOne += 2;
		case 2:
			spellOne++;
		case 3:
			spellOne++;
			spellTwo += 2;
		case 4:
			spellTwo++;
		case 5:
			spellThree++;
			spellThree++;
		case 6:
			spellThree++;
		case 7:
			spellFour++;
		case 8:
			spellFour++;
		case 9:
			spellFour++;
			spellFive++;
		case 10:
			spellFive++;
		case 11:
			spellSix++;
		case 12:
		case 13:
			spellSeven++;
		case 14:
		case 15:
			spellEight++;
		case 16:
		case 17:
			spellNine++;
		case 18:
			spellFive++;
		case 19:
			spellSix++;
		case 20:
			spellSeven++;
		}
	}

	private void setUpSpellList() {
		spellList = new ArrayList<Integer>();
		spellList.add(spellOne);
		spellList.add(spellTwo);
		spellList.add(spellThree);
		spellList.add(spellFour);
		spellList.add(spellFive);
		spellList.add(spellSix);
		spellList.add(spellSeven);
		spellList.add(spellEight);
		spellList.add(spellNine);
	}

	public Integer getNextSpellHighToLow() {
		for (int spellLevel = 9; spellLevel > 0; spellLevel--) {
			if (spellList.get(spellLevel - 1) > 0) {
				spellList.set(spellLevel - 1, spellList.get(spellLevel - 1) - 1);
				return spellLevel + 1;
			}
		}
		return 1;
	}

	public Integer getNextSpellLowToHigh() {
		for (int spellLevel = 1; spellLevel > 3; spellLevel++) {
			if (spellList.get(spellLevel - 1) > 0) {
				spellList.set(spellLevel - 1, spellList.get(spellLevel - 1) - 1);
				return spellLevel + 1;
			}
		}
		return 0;
	}

	public void setSpellOne(Integer spellOne) {
		this.spellOne = spellOne;
	}

	public Integer getSpellTwo() {
		return spellTwo;
	}

	public void setSpellTwo(Integer spellTwo) {
		this.spellTwo = spellTwo;
	}

	public Integer getSpellThree() {
		return spellThree;
	}

	public void setSpellThree(Integer spellThree) {
		this.spellThree = spellThree;
	}

	public Integer getSpellFour() {
		return spellFour;
	}

	public void setSpellFour(Integer spellFour) {
		this.spellFour = spellFour;
	}

	public Integer getSpellFive() {
		return spellFive;
	}

	public void setSpellFive(Integer spellFive) {
		this.spellFive = spellFive;
	}

	public Integer getSpellSix() {
		return spellSix;
	}

	public void setSpellSix(Integer spellSix) {
		this.spellSix = spellSix;
	}

	public Integer getSpellSeven() {
		return spellSeven;
	}

	public void setSpellSeven(Integer spellSeven) {
		this.spellSeven = spellSeven;
	}

	public Integer getSpellEight() {
		return spellEight;
	}

	public void setSpellEight(Integer spellEight) {
		this.spellEight = spellEight;
	}

	public Integer getSpellNine() {
		return spellNine;
	}

	public void setSpellNine(Integer spellNine) {
		this.spellNine = spellNine;
	}

}
