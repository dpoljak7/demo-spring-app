package com.example.demo;

import com.example.demo.utils.DataGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class DemoApplication implements CommandLineRunner {

	public static final int NUMBER_OF_PURCHASES_IN_DATABASE_TO_BE_GENERATED = 20;
	public static final int NUMBER_OF_CUSTOMERS_IN_DATABASE_TO_BE_GENERATED = 3;
	public static final int NUMBER_OF_ITEMS_IN_DATABASE_TO_BE_GENERATED = 4;

	@Autowired
	private DataGenerator dataGenerator;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		int numberOfPurchases = NUMBER_OF_PURCHASES_IN_DATABASE_TO_BE_GENERATED;
		if (args.length == 1) {
			numberOfPurchases = Integer.parseInt(args[0]);
		}
		dataGenerator.generateDataInDatabase(numberOfPurchases, NUMBER_OF_CUSTOMERS_IN_DATABASE_TO_BE_GENERATED, NUMBER_OF_ITEMS_IN_DATABASE_TO_BE_GENERATED);
	}

}
