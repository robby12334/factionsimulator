package com.factionsimulator.fs.combat.classes;

import com.factionsimulator.fs.data.dao.Character;

public class Barbarian extends Combatant implements CharacterSetUp {

	public Barbarian(Character character) {
		super(character);
		setDEX();
		setCON();
		setSTR();
		setSaves();
		setAc();
		setAttacks();
		addAddedDamage(getStr());
		setHitDie(12);
		setToHit(getStr() + getProficiancy());
		setCurHp(getCharacter().getHitPoints() + (getCon() * getLevel()));
		if (getLevel() > 2) {
			setHasAdvantage(true);
			setGivesAdvantage(true);
		}

	}

	private void setAttacks() {
		if (getLevel() < 5) {
			setAttacks(1);
		} else if (getLevel() < 17) {
			setAttacks(2);
		} else if (getLevel() == 20){
			setAttacks(3);
		}
	}

	private void addAddedDamage(Integer str) {
		int rageBonus = 0;
		if (getLevel() < 9) {
			rageBonus += 2;
		} else if (getLevel() < 16) {
			rageBonus += 3;
		} else {
			rageBonus += 4;
		}
		setAddedDamage(str + rageBonus);
	}

	@Override
	public void setDEX() {
		if (getLevel() < 19) {
			setDex(2);
		} else {
			setDex(3);
		}
	}

	@Override
	public void setCON() {
		if (getLevel() < 12) {
			setCon(3);
		} else if (getLevel() < 16) {
			setCon(4);
		} else {
			setCon(5);
		}
	}

	@Override
	public void setSTR() {
		if (getLevel() < 4) {
			setStr(3);
		} else if (getLevel() < 8) {
			setStr(4);
		} else {
			setStr(5);
		}
	}

	@Override
	public void setAc() {
		setAC(10 + getDex() + getCon());
	}

	@Override
	public void setSaves() {
		setStrSave(true);
		setConSave(true);
		if (getLevel() > 2) {
			setDexSave(true);
		}
	}
	
	@Override
	protected Integer takeDamage(Integer damage, boolean passed, String save) {
		damage = damage / 2;
		return super.takeDamage(damage, passed, save);
	}
	
	@Override
	public Integer round(Combatant combatant) {
		return combatRound(combatant,1,12);
	}



}
