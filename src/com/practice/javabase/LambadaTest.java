package com.practice.javabase;

import java.util.function.Consumer;

/**
 * lambada表达式 
 * @author Cloud
 *
 */
public class LambadaTest {

	public static void main(String[] args) {
		People.doSomething(() -> System.out.print("say hi"));
	}
	
}

@FunctionalInterface
interface Action {
	void action();
}

class People {
	public static void doSomething(Action action) {
		action.action();
	}
}

