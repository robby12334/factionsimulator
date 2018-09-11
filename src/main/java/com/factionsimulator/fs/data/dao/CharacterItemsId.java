package com.factionsimulator.fs.data.dao;

import java.io.Serializable;
import java.util.Objects;

public class CharacterItemsId implements Serializable {
	private static final long serialVersionUID = -1770260571467922456L;

	private String className;
	private Integer characterId;

	public CharacterItemsId() {
	}

	public CharacterItemsId(String className, Integer characterId) {
		this.className = className;
		this.characterId = characterId;
	}

	@Override
	public boolean equals(Object o) {

		if (o == this) {
			return true;
		}
		if (!(o instanceof Character_Items)) {
			return false;
		}

		Character_Items charItems = (Character_Items) o;
		return Objects.equals(className, charItems.getClassName())
				&& Objects.equals(characterId, charItems.getCharacterId());
	}

}
