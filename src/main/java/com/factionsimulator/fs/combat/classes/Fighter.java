package com.factionsimulator.fs.combat.classes;

import com.factionsimulator.fs.data.dao.Character;

public class Fighter extends Combatant implements CharacterSetUp {

	public Fighter(Character character) {
		super(character);
		setDEX();
		setCON();
		setSTR();
		setSaves();
		setAc();
		setAttacks();
		addAddedDamage(getStr());
		setHitDie(10);
		critRange();
		setToHit(getStr() + getProficiancy());
		setCurHp(getCharacter().getHitPoints() + (getCon() * getLevel()));
	}

	private void critRange() {
		if (getLevel() > 2) {
			setCritRange(19);
		} else if (getLevel() > 14) {
			setCritRange(18);
		}
	}

	private void addAddedDamage(Integer str) {
		int dmgBonus = 0;
		if (getLevel() > 5) {
			dmgBonus += 2;
		} else if (getLevel() > 10) {
			dmgBonus += 4;
		} else if (getLevel() > 13) {
			dmgBonus += 6;
		}
		setAddedDamage(str + dmgBonus);
	}

	private void setAttacks() {
		if (getLevel() < 5) {
			setAttacks(1);
		} else if (getLevel() < 17) {
			setAttacks(2);
		} else if (getLevel() < 20){
			setAttacks(3);
		} else {
			setAttacks(4);
		}
	}

	@Override
	public void setDEX() {
		setDex(14);
	}

	@Override
	public void setCON() {
		if (getLevel() < 8) {
			setCon(3);
		} else if (getLevel() < 12) {
			setCon(4);
		} else {
			setCon(5);
		}
	}

	@Override
	public void setSTR() {
		if (getLevel() < 4) {
			setStr(3);
		} else if (getLevel() < 6) {
			setStr(4);
		} else {
			setStr(5);
		}
	}

	@Override
	public void setAc() {
		setAC(21);
	}

	@Override
	public void setSaves() {
		setConSave(true);
		setStrSave(true);
	}

	private void regen() {
		if (getLevel() > 3) {
			setCurHp(getCurHp() + roll(1, 10));
		} else if (getLevel() > 7) {
			setCurHp(getCurHp() + roll(2, 10));
		} else if (getLevel() > 11) {
			setCurHp(getCurHp() + roll(3, 10));
		} else if (getLevel() > 16) {
			setCurHp(getCurHp() + roll(4, 10));
		}
	}

	@Override
	public Integer round(Combatant combatant) {
		regen();
		return combatRound(combatant, 1, 8);
	}

}
