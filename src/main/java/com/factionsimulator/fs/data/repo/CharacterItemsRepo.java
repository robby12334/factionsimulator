package com.factionsimulator.fs.data.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.factionsimulator.fs.data.dao.Character_Items;

@Component
public interface CharacterItemsRepo extends CrudRepository<Character_Items, Long> {

}
