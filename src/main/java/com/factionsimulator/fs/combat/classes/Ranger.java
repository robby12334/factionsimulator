package com.factionsimulator.fs.combat.classes;

import com.factionsimulator.fs.data.dao.Character;

public class Ranger extends Combatant implements CharacterSetUp {

	public Ranger(Character character) {
		super(character);
		setDEX();
		setCON();
		setSTR();
		setSaves();
		setAc();
		setAttacks();
		setHitDie(10);
		critRange();
		setAddedDamageAndToHit();
		setCurHp(getCharacter().getHitPoints() + (getCon() * getLevel()));
	}
	
	private void setAddedDamageAndToHit(){
		if(getLevel() < 8) {
			setToHit(getDex() + getProficiancy());
			setAddedDamage(getDex() + 2);
		}else {
			setToHit(getDex() + getProficiancy() - 5);
			setAddedDamage(getDex() + 12);
		}
	}

	private void critRange() {
		if (getLevel() > 2) {
			setCritRange(19);
		} else if (getLevel() > 14) {
			setCritRange(18);
		}
	}

	private void setAttacks() {
		if (getLevel() < 5) {
			setAttacks(1);
		} else if (getLevel() < 17) {
			setAttacks(2);
		} else if (getLevel() < 20) {
			setAttacks(3);
		} else {
			setAttacks(4);
		}
	}

	@Override
	public void setDEX() {
		if (getLevel() < 4) {
			setDex(3);
		} else if (getLevel() < 6) {
			setDex(4);
		} else {
			setDex(5);
		}
	}

	@Override
	public void setCON() {
		setCon(16);
	}

	@Override
	public void setSTR() {
		setStr(0);
	}

	@Override
	public void setAc() {
		if (getLevel() < 10) {
			setAC(getDex() +  13);
		} else {
			setAC(getDex() +  14);
		}
	}

	@Override
	public void setSaves() {
		setWisSave(true);
		setDexSave(true);
	}

	@Override
	public Integer round(Combatant combatant) {
		return combatRound(combatant, 1, 8);
	}

}
