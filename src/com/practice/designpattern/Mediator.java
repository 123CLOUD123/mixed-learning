package com.practice.designpattern;

/**
 * 中介者模式
 * 
 * @author ZhangHao
 */
public class Mediator {

	static class Person {
		
		public final String name;
		
		Person(String name) {
			this.name = name;
		}
		
		public void sellHouse() {
			Agency.sellHouse(this.name);
		}
		
	}
	
	static class Agency {
		
		public static void sellHouse(String name) {
			System.out.println(name + " is selling house");
		}
		
	}

	public static void main(String[] args) {
		Person tom = new Person("Tom");
		Person lily = new Person("Lily");
		tom.sellHouse();
		lily.sellHouse();
	}
	
}
