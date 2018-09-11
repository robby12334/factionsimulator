package com.factionsimulator.fs.data.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.factionsimulator.fs.data.dao.Factions;

@Component
public interface FactionsRepo extends CrudRepository<Factions, Long> {
	
}
