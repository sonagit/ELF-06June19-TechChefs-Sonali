package com.techchefs.springcore.annotationtest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techchefs.springcore.beans.Pet;
import com.techchefs.springcore.configurations.PetConfig;

public class AnimalTest {

	public static void main(String[] args) {

		/*
		 * ApplicationContext ctx = new
		 * AnnotationConfigApplicationContext(PetConfig.class);
		 * 
		 * Pet pet = ctx.getBean(Pet.class);
		 * 
		 * pet.doSomething();
		 */
		
		ApplicationContext ctxXml = new ClassPathXmlApplicationContext("petConfig.xml");
		Pet petXml = (Pet) ctxXml.getBean("pet");
		
		petXml.doSomething();
	}

}
