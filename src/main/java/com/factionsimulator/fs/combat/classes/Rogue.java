package com.factionsimulator.fs.combat.classes;

import com.factionsimulator.fs.data.dao.Character;

public class Rogue extends Combatant implements CharacterSetUp {

	public Rogue(Character character) {
		super(character);
		setDex();
		setCon();
		setStr();
		setSaves();
		setAc();
		hitDie = 8;
		toHit = dex + proficiancy;
		addedDamage = dex;
		attacks = 1;
	}

	@Override
	public Integer combatRound(Combatant combatant, Integer AC, Integer numDice, Integer diceType) {
		int total = 0;
		if (curHp > 0) {
			int diceDamage = roll(numDice, diceType) + sneakAttack();
			total += attackDamage(combatant, toHit, diceDamage, addedDamage);
		}
		return total;
	}

	public Integer sneakAttack() {
		return roll((int) ((getLevel() + 1) / 2), 6);
	}

	@Override
	public Integer takeDamage(Integer damage, boolean passed, String save) {
		if (!(passed && save.equals("dex") && getLevel() >= 7)) {
			if (getLevel() >= 7 && save.equals("dex")) {
				this.curHp -= damage / 2;
				return damage / 2;
			} else {
				return damage;
			}
		}
		return 0;
	}

	@Override
	public void setDex() {
		if (getLevel() < 4) {
			dex = 3;
		} else if (getLevel() < 8) {
			dex = 4;
		} else {
			dex = 5;
		}
	}

	@Override
	public void setCon() {
		if (getLevel() < 12) {
			con = 0;
		} else if (getLevel() < 16) {
			con = 1;
		} else {
			con = 2;
		}
	}

	@Override
	public void setStr() {
		str = -1;
	}

	@Override
	public void setAc() {
		AC = dex + 13;
	}

	@Override
	public void setSaves() {
		dexSave = true;
		chaSave = true;
	}

}
