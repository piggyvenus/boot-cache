package com.lukeshannon.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class HeroTest {
	private Map<String, String> heroes;

	private static final Logger log = LoggerFactory.getLogger(HeroController.class);

	@PostConstruct
	public void initHeroes() {
		heroes = new HashMap<String, String>();
		heroes.put("john", "john_blum");
		heroes.put("josh", "starbuxman");
		heroes.put("stu", "svrc");
		heroes.put("dormain", "DormainDrewitz");
		heroes.put("cornelia", "cdavisafc");
		heroes.put("saman", "err_sage");
		heroes.put("casey", "caseywest");
		heroes.put("kenny", "kennybastani");
		heroes.put("jim", "JavaFXpert");
		heroes.put("mark", "MkHeck");
		heroes.put("bridgette", "bridgetkromhout");
	}


	@Cacheable(cacheNames = "hero")
	public String testLookUp(String name) {
		String result = expensiveLookUp(name);
		return result;
	}

	private String expensiveLookUp(String name) {
		log.debug("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		log.debug("$$$$$$$$$$$$$$$ In the expensive look up for the name: " + name + " $$$$$$$$$$$$$$$");
		log.debug("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		return heroes.get(name);
	}
}
