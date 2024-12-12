package com.mapping.onetomany.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJpaOneToManyApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringJpaOneToManyApplication.class, args);
		String[] getBeanNames = applicationContext.getBeanDefinitionNames();
		List.of(getBeanNames).forEach(System.out::println);
	}

}
