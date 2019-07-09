package com.practice.test;

import com.practice.designpattern.Singleton;

public class Test {

	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s1.equals(s2));
	}
	
}
