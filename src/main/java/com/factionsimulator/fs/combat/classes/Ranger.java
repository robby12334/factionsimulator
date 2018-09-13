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
		setAddedDamage(getDex());
		setHitDie(10);
		setToHit(getStr() + getProficiancy());
		// TODO Auto-generated constructor stub
		setCurHp(getCharacter().getHitPoints() + (getCon() * getLevel()));
	}

	private void setAttacks() {
		if (getLevel() < 5) {
			setAttacks(1);
		} else if (getLevel() < 17) {
			setAttacks(2);
		} else {
			setAttacks(3);
		}
	}
	
	@Override
	public void setDEX() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCON() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSTR() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAc() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSaves() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer round(Combatant combatant) {
		// TODO Auto-generated method stub
		return null;
	}

}
