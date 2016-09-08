/**
 * 
 */
package com.lukeshannon.controller;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lshannon
 *
 */
@RestController
@RequestMapping("/v1")
public class HeroController {
	@Autowired
	private HeroTest heroTest;
	
	
	@RequestMapping("/getTwitterHandle/{name}")
	public String getHero(@PathVariable String name) {
		String result = heroTest.testLookUp(name);
		return result;
	}
	
}

@RestController
class HomeController {

	@RequestMapping("/")
	public String home() {
		return "Run /v1/getTwitterHandle/{name} to find the twitter handle of your hero";
	}
}



