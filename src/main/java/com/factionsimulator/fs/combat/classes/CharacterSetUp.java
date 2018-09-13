package com.factionsimulator.fs.combat.classes;

public interface CharacterSetUp {
	public void setDEX();
	public void setCON();
	public void setSTR();
	public void setAc();
	public void setSaves();	
	public Integer round(Combatant combatant);
	
}
