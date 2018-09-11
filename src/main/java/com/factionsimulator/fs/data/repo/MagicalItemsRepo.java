package com.factionsimulator.fs.data.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.factionsimulator.fs.data.dao.Magical_Items;

@Component
public interface MagicalItemsRepo extends CrudRepository<Magical_Items, Long> {
	
}
