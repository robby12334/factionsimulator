package com.factionsimulator.fs.combat.classes;

import java.util.ArrayList;

public class Combatant {
	protected com.factionsimulator.fs.data.dao.Character character;
	protected Integer curHp;
	protected Integer toHit;
	protected Integer addedDamage;
	protected Integer proficiancy;
	protected Integer attacks = 1;
	protected Integer AC = 0;

	protected boolean hasAdvantage = false;
	protected boolean givesAdvantage = false;

	// Dice
	protected Integer hitDie;

	// Saves
	protected Integer str = 0;
	protected boolean strSave = false;
	protected Integer dex = 0;
	protected boolean dexSave = false;
	protected Integer con = 0;
	protected boolean conSave = false;
	protected Integer wis = 2;
	protected boolean wisSave = false;
	protected Integer intel = 0;
	protected boolean intSave = false;
	protected Integer cha = 2;
	protected boolean chaSave = false;

	public Combatant(com.factionsimulator.fs.data.dao.Character character) {
		this.character = character;
		setProficiancy();
		curHp = character.getHitPoints();
	}

	public Integer getLevel() {
		return character.getClassLevel();
	}

	public com.factionsimulator.fs.data.dao.Character getCharacter() {
		return character;
	}

	public void setCurHp(Integer curHp) {
		this.curHp = curHp;
	}

	public void setProficiancy() {
		if (getLevel() < 5) {
			proficiancy = 2;
		} else if (getLevel() < 5) {
			proficiancy = 3;
		} else if (getLevel() < 5) {
			proficiancy = 4;
		} else if (getLevel() < 5) {
			proficiancy = 5;
		} else {
			proficiancy = 6;
		}
	}

	public Integer roll(Integer numberOfDice, Integer typeOfDice) {
		int total = 0;
		for (int i = 0; i < numberOfDice; i++) {
			int temp = (int) Math.ceil(Math.random() * typeOfDice);
			total += temp;
		}
		return total;
	}

	public Integer twenty() {
		return roll(1, 20);
	}

	public Integer advantage() {
		int dice1 = twenty();
		int dice2 = twenty();
		return dice1 > dice2 ? dice1 : dice2;
	}

	public Integer attack() {
		return hasAdvantage ? advantage() : twenty();
	}

	private boolean save(Integer roll, Integer DC, Integer bonus, boolean prof) {
		return roll + bonus >= (prof ? DC - proficiancy : DC);
	}

	public boolean strSave(Integer DC) {
		return save(twenty(), DC, str, strSave);
	}

	public boolean dexSave(Integer DC) {
		return save(twenty(), DC, dex, dexSave);
	}

	public boolean conSave(Integer DC) {
		return save(twenty(), DC, con, conSave);
	}

	public boolean wisSave(Integer DC) {
		return save(twenty(), DC, wis, wisSave);
	}

	public boolean intSave(Integer DC) {
		return save(twenty(), DC, intel, intSave);
	}

	public boolean chaSave(Integer DC) {
		return save(twenty(), DC, cha, chaSave);
	}

	protected boolean isHit(Integer dice, Integer toHit) {
		if ((dice + toHit >= AC) || dice == 20) {
			return true;
		}
		return false;
	}

	public Integer combatRound(Combatant combatant, Integer AC, Integer numDice, Integer diceType) {
		int total = 0;
		if (curHp > 0) {
			for (int i = 0; i < attacks; i++) {
				total += attackDamage(combatant, toHit, roll(numDice, diceType), addedDamage);
			}
		}
		return total;
	}

	protected Integer takeDamage(Integer damage, boolean passed, String save) {
		if (passed) {
			this.curHp -= damage / 2;
			return damage / 2;
		} else {
			this.curHp -= damage;
			return damage;
		}
	}

	protected Integer damage(Combatant combatant, Integer damage) {
		return combatant.takeDamage(damage, false, "");
	}

	public Integer saveDamage(Combatant combatant, Integer damage, boolean passed, String save) {
		return combatant.takeDamage(damage, passed, save);
	}

	public Integer saveDamage(Combatant combatant, Integer damage, Integer DC, String save) {
		boolean passed = false;
		switch (save) {
		case "str":
			passed = strSave(DC);
			break;
		case "dex":
			passed = dexSave(DC);
			break;
		case "con":
			passed = conSave(DC);
			break;
		case "wis":
			passed = wisSave(DC);
			break;
		case "intel":
			passed = intSave(DC);
			break;
		case "cha":
			passed = chaSave(DC);
			break;
		}
		return saveDamage(combatant, damage, passed, save);
	}

	public Integer attackDamage(Combatant combatant, Integer toHit, Integer diceDamage, Integer damageBonus) {
		int die = combatant.givesAdvantage ? advantage() : attack();
		int total = 0;
		if ((die + toHit >= combatant.AC) || die == 20) {
			total += damage(combatant, (die == 20 ? diceDamage * 2 : diceDamage) + damageBonus);
		}
		return total;
	}

	public Integer round(Integer AC) {
		return null;
	}

	public static void main(String[] args) {
		com.factionsimulator.fs.data.dao.Character character = new com.factionsimulator.fs.data.dao.Character();
		character.setClassLevel(20);
		character.setClassName("ROGUE");
		character.setHitPoints(1);
		Rogue rogue = new Rogue(character);

		ArrayList<Combatant> comb = new ArrayList<Combatant>();
		comb.add(rogue);

		for (int i = 0; i < 100; i++) {
			System.out.println(rogue.round(10));
		}

	}

}
