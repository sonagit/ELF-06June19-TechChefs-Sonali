package com.techchefs.springcore.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.techchefs.springcore.beans.Donkey;
import com.techchefs.springcore.beans.Monkey;
import com.techchefs.springcore.beans.Pet;
import com.techchefs.springcore.interfaces.Animal;

@Configuration
public class PetConfig {

	@Bean
	public Pet getPet() {
		
		return new Pet();
	}
	
	@Bean(name="monkey")
	public Animal getMonkey() {
		return new Monkey();
	}
	
	@Bean(name="donkey")
	public Animal getDonkey() {
		return new Donkey();
	}
}
