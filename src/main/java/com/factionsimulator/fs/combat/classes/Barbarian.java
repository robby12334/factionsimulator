package com.factionsimulator.fs.combat.classes;

import com.factionsimulator.fs.data.dao.Character;

public class Barbarian extends Combatant implements CharacterSetUp {

	public Barbarian(Character character) {
		super(character);
		setDex();
		setCon();
		setStr();
		setSaves();
		setAc();
		setAttacks();
		addAddedDamage(str);
		hitDie = 12;
		toHit = str + proficiancy;

		if (getLevel() > 2) {
			hasAdvantage = true;
			givesAdvantage = true;
		}

	}

	private void setAttacks() {
		if (getLevel() < 5) {
			attacks = 1;
		} else if (getLevel() < 17) {
			attacks = 2;
		} else {
			attacks = 3;
		}
	}

	private void addAddedDamage(Integer str) {
		toHit += str;
		if (getLevel() < 9) {
			toHit += 2;
		} else if (getLevel() < 16) {
			toHit += 3;
		} else {
			toHit += 4;
		}

	}

	@Override
	public void setDex() {
		if (getLevel() < 19) {
			dex = 2;
		} else {
			dex = 3;
		}
	}

	@Override
	public void setCon() {
		if (getLevel() < 12) {
			con = 3;
		} else if (getLevel() < 16) {
			con = 4;
		} else {
			con = 5;
		}
	}

	@Override
	public void setStr() {
		if (getLevel() < 4) {
			str = 3;
		} else if (getLevel() < 8) {
			str = 4;
		} else {
			str = 5;
		}
	}

	@Override
	public void setAc() {
		AC = 10 + dex + con;
	}

	@Override
	public void setSaves() {
		strSave = true;
		conSave = true;
		if (getLevel() > 2) {
			dexSave = true;
		}
	}

}
