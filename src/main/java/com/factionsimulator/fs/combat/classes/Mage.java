package com.factionsimulator.fs.combat.classes;

import com.factionsimulator.fs.data.dao.Character;

public class Mage extends SpellCaster implements CharacterSetUp {

	public Mage(Character character) {
		super(character);
		setDEX();
		setCON();
		setSTR();
		setSaves();
		setAc();
		setHitDie(6);
		setToHit(getStr() + getProficiancy());
		// TODO Auto-generated constructor stub
		setCurHp(getCharacter().getHitPoints() + (getCon() * getLevel()));
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
