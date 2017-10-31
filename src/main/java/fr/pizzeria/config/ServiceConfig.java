package fr.pizzeria.config;

import java.util.Scanner;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.slf4j.*;

import fr.pizzeria.console.PizzeriaAdminConsoleApp;

@Configuration
@ComponentScan({"fr.pizzeria.ihm", "fr.pizzeria.console", "fr.pizzeria.dao"})
public class ServiceConfig {
	@Bean
	public Scanner scanner(){
		return new Scanner(System.in);
	}
	
	@Bean
	public Logger logger(){
		return LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);
	}
	
}
