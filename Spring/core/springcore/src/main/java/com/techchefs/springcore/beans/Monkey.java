package com.techchefs.springcore.beans;

import com.techchefs.springcore.interfaces.Animal;

public class Monkey implements Animal{

	public void eat() {

		System.out.println("monkey eat");
	}

	public void makeSound() {

		System.out.println("monkey sound");
	}

}
