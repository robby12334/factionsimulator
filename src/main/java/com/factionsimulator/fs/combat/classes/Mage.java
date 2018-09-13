package com.factionsimulator.fs.combat.classes;

import com.factionsimulator.fs.data.dao.Character;

public class Mage extends SpellCaster implements CharacterSetUp {

	public Mage(Character character) {
		super(character);
		setDEX();
		setCON();
		setSTR();
		setINT();
		setSaves();
		setAc();
		setHitDie(6);
		setToHit(getStr() + getProficiancy());
		setCurHp(getCharacter().getHitPoints() + (getCon() * getLevel()));
	}

	@Override
	public boolean doesItHit(Integer die, Integer toHit, Integer critRange) {
		if (die >= critRange) {
			return true;
		} else if (die + toHit <= super.getAC()) {
			return false;
		} else {
			if(die + toHit - 5 <= super.getAC() && super.getNextSpellLowToHigh() > 0) {
				
			}
		}
		return false;
	}

	private void setINT() {
		if (getLevel() < 4) {
			setIntel(3);
		} else if (getLevel() < 8) {
			setIntel(4);
		} else {
			setIntel(5);
		}
	}

	@Override
	public void setDEX() {
		if (getLevel() < 12) {
			setDex(3);
		} else if (getLevel() < 16) {
			setDex(4);
		} else {
			setDex(5);
		}
	}

	@Override
	public void setCON() {
		super.setCon(1);
	}

	@Override
	public void setSTR() {
		super.setStr(-1);
	}

	@Override
	public void setAc() {
		super.setAC(getDex() + 8);
	}

	@Override
	public void setSaves() {
		super.setWisSave(true);
		super.setIntSave(true);
	}

	@Override
	public Integer round(Combatant combatant) {
		return super.combatRound(combatant, super.getNextSpellHighToLow(), 10);
	}

}
