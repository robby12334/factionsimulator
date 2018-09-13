package com.factionsimulator.fs.combat.classes;

import com.factionsimulator.fs.data.dao.Character;

public class Rogue extends Combatant implements CharacterSetUp {

	public Rogue(Character character) {
		super(character);
		setDEX();
		setCON();
		setSTR();
		setSaves();
		setAc();
		setHitDie(8);
		setToHit(getDex() + getProficiancy());
		setCurHp(getCharacter().getHitPoints() + (getCon() * getLevel()));
		setAddedDamage(getDex());
	}

	@Override
	public Integer attackDamage(Combatant combatant, Integer toHit, Integer diceDamage, Integer damageBonus) {
		diceDamage += sneakAttack();
		return super.attackDamage(combatant, toHit, diceDamage, damageBonus);
	}
	
	@Override
	public Integer combatRound(Combatant combatant, Integer numDice, Integer diceType) {
		int total = 0;
		if (isAlive()) {
			int diceDamage = roll(numDice, diceType) + sneakAttack();
			total += attackDamage(combatant, getToHit(), diceDamage, getAddedDamage());
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
				return removeHP(damage / 2);
			} else {
				return removeHP(damage);
			}
		}
		return 0;
	}

	@Override
	public void setDEX() {
		if (getLevel() < 4) {
			setDex(3);
		} else if (getLevel() < 8) {
			setDex(4);
		} else {
			setDex(5);
		}
	}

	@Override
	public void setCON() {
		if (getLevel() < 12) {
			setCon(0);
		} else if (getLevel() < 16) {
			setCon(1);
		} else {
			setCon(2);
		}
	}

	@Override
	public void setSTR() {
		setStr(-1);
	}

	@Override
	public void setAc() {
		setAC(getDex() + 13);
	}

	@Override
	public void setSaves() {
		setDexSave(true);
		setChaSave(true);
	}

	@Override
	public Integer round(Combatant combatant) {
		return combatRound(combatant,1,4);
	}

}
