package com.factionsimulator.fs.data.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.factionsimulator.fs.data.dao.Classes;

@Component
public interface CharacterRepo extends CrudRepository<Classes, Long> {
	
	List<Classes> findByClassName (String className);
	
	@Query("SELECT c FROM Classes c")
	List<Classes> findAllClasses();
}
