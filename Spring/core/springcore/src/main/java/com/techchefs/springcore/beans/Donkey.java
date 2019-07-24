package com.techchefs.springcore.beans;

import com.techchefs.springcore.interfaces.Animal;

public class Donkey implements Animal{

	public void eat() {

		System.out.println("eat grass");
	}

	public void makeSound() {

		System.out.println("dhechu dhechu");
	}

}
