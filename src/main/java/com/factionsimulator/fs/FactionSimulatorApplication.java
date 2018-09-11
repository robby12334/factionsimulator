package com.factionsimulator.fs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableCaching
//@EnableJpaRepositories(basePackages ={"com.factionservice.fs.repo"})
//@ComponentScan(basePackages = {"\"com.factionservice.fs.*"})
public class FactionSimulatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(FactionSimulatorApplication.class, args);
	}
}
