package com.said_market;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootTest
class SaidMarketApplicationTests {

	@BeforeAll
	static void setup(){
		Dotenv dotenv = Dotenv.load();
		System.setProperty("spring.datasource.url", dotenv.get("DB_URL"));
		System.setProperty("spring.datasource.username", dotenv.get("DB_USERNAME"));
		System.setProperty("spring.datasource.password", dotenv.get("DB_PASSWORD"));
	}
	@Test
	void contextLoads() {
	}

}
