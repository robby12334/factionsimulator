package com.factionsimulator.fs.combat.classes;

public class Combatant {
	private com.factionsimulator.fs.data.dao.Character character;
	private Integer curHp = 999;
	private Integer toHit = 0;
	private Integer addedDamage = 0;
	private Integer proficiancy = 0;
	private Integer attacks = 1;
	private Integer AC = 0;
	private Integer critRange = 20;
	private boolean hasAdvantage = false;
	private boolean givesAdvantage = false;

	// Dice
	private Integer hitDie = 6;

	// Saves
	private Integer str = 0;
	private boolean strSave = false;
	private Integer dex = 0;
	private boolean dexSave = false;
	private Integer con = 0;
	private boolean conSave = false;
	private Integer wis = 2;
	private boolean wisSave = false;
	private Integer intel = 0;
	private boolean intSave = false;
	private Integer cha = 2;
	private boolean chaSave = false;

	public Combatant(com.factionsimulator.fs.data.dao.Character character) {
		this.character = character;
		setProficiancy();
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

	public boolean isAlive() {
		return this.curHp > 0;
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
		if ((dice + toHit >= AC) || dice >= critRange) {
			return true;
		}
		return false;
	}

	public Integer combatRound(Combatant combatant, Integer numDice, Integer diceType) {
		int total = 0;
		if (isAlive()) {
			for (int i = 0; i < attacks; i++) {
				total += attackDamage(combatant, toHit, roll(numDice, diceType), addedDamage);
			}
		}
		return total;
	}

	public int removeHP(Integer damage) {
		curHp -= damage;
		return damage;
	}

	protected Integer takeDamage(Integer damage, boolean passed, String save) {
		if (passed) {
			return removeHP(damage / 2);
		} else {
			return removeHP(damage);
		}
	}

	protected Integer damage(Combatant combatant, Integer damage) {
		int dmg = combatant.takeDamage(damage, false, "");
		System.out
				.println(character.getFirstName() + " Dealt " + dmg + " To " + combatant.getCharacter().getFirstName());
		return dmg;
	}

	public Integer saveDamage(Combatant combatant, Integer damage, boolean passed, String save) {
		int dmg = combatant.takeDamage(damage, passed, save);
		System.out
				.println(character.getFirstName() + " Dealt " + dmg + " To " + combatant.getCharacter().getFirstName());
		return dmg;
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

	public boolean doesItHit(Integer die, Integer toHit, Integer critRange) {
		if ((die + toHit >= getAC()) || die >= critRange)
			return true;
		return false;
	}
	
	public Integer attackDamage(Combatant combatant, Integer toHit, Integer diceDamage, Integer damageBonus) {
		int die = combatant.getGivesAdvantage() || getHasAdvantage() ? advantage() : attack();
		int total = 0;
		if (combatant.doesItHit(die, toHit, critRange)) {
			total += damage(combatant, (die >= critRange ? diceDamage * 2 : diceDamage) + damageBonus);
		} else {
			System.out.println(character.getFirstName() + " Missed " + combatant.getCharacter().getFirstName());
		}
		return total;
	}

	public static void main(String[] args) {
		com.factionsimulator.fs.data.dao.Character character = new com.factionsimulator.fs.data.dao.Character();
		character.setClassLevel(10);
		character.setClassName("ROGUE");
		character.setHitPoints(93);
		character.setFirstName("Rogue");
		Rogue rogue = new Rogue(character);
		character = new com.factionsimulator.fs.data.dao.Character();
		character.setClassLevel(10);
		character.setClassName("BARBARIAN");
		character.setFirstName("Barbarian");
		character.setHitPoints(93);
		Barbarian barb = new Barbarian(character);

		while (barb.isAlive() && rogue.isAlive()) {
			int rand = (int) (Math.random() * 100);

			if (rand % 2 == 0) {
				barb.combatRound(rogue, 1, 12);
				rogue.round(barb);

			} else {
				rogue.round(barb);
				barb.combatRound(rogue, 1, 12);
			}

		}
	}

	public Integer getToHit() {
		return toHit;
	}

	public void setToHit(Integer toHit) {
		this.toHit = toHit;
	}

	public Integer getAddedDamage() {
		return addedDamage;
	}

	public void setAddedDamage(Integer addedDamage) {
		this.addedDamage = addedDamage;
	}

	public Integer getProficiancy() {
		return proficiancy;
	}

	public void setProficiancy(Integer proficiancy) {
		this.proficiancy = proficiancy;
	}

	public Integer getAttacks() {
		return attacks;
	}

	public void setAttacks(Integer attacks) {
		this.attacks = attacks;
	}

	public Integer getAC() {
		return AC;
	}

	public void setAC(Integer aC) {
		AC = aC;
	}

	public Integer getCritRange() {
		return critRange;
	}

	public void setCritRange(Integer critRange) {
		this.critRange = critRange;
	}

	public boolean getHasAdvantage() {
		return hasAdvantage;
	}

	public void setHasAdvantage(boolean hasAdvantage) {
		this.hasAdvantage = hasAdvantage;
	}

	public boolean getGivesAdvantage() {
		return givesAdvantage;
	}

	public void setGivesAdvantage(boolean givesAdvantage) {
		this.givesAdvantage = givesAdvantage;
	}

	public Integer getHitDie() {
		return hitDie;
	}

	public void setHitDie(Integer hitDie) {
		this.hitDie = hitDie;
	}

	public Integer getStr() {
		return str;
	}

	public void setStr(Integer str) {
		this.str = str;
	}

	public boolean isStrSave() {
		return strSave;
	}

	public void setStrSave(boolean strSave) {
		this.strSave = strSave;
	}

	public Integer getDex() {
		return dex;
	}

	public void setDex(Integer dex) {
		this.dex = dex;
	}

	public boolean isDexSave() {
		return dexSave;
	}

	public void setDexSave(boolean dexSave) {
		this.dexSave = dexSave;
	}

	public Integer getCon() {
		return con;
	}

	public void setCon(Integer con) {
		this.con = con;
	}

	public boolean isConSave() {
		return conSave;
	}

	public void setConSave(boolean conSave) {
		this.conSave = conSave;
	}

	public Integer getWis() {
		return wis;
	}

	public void setWis(Integer wis) {
		this.wis = wis;
	}

	public boolean isWisSave() {
		return wisSave;
	}

	public void setWisSave(boolean wisSave) {
		this.wisSave = wisSave;
	}

	public Integer getIntel() {
		return intel;
	}

	public void setIntel(Integer intel) {
		this.intel = intel;
	}

	public boolean isIntSave() {
		return intSave;
	}

	public void setIntSave(boolean intSave) {
		this.intSave = intSave;
	}

	public Integer getCha() {
		return cha;
	}

	public void setCha(Integer cha) {
		this.cha = cha;
	}

	public boolean isChaSave() {
		return chaSave;
	}

	public void setChaSave(boolean chaSave) {
		this.chaSave = chaSave;
	}

	public Integer getCurHp() {
		return curHp;
	}

	public void setCharacter(com.factionsimulator.fs.data.dao.Character character) {
		this.character = character;
	}

}
