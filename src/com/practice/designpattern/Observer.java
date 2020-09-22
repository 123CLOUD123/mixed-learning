package com.practice.designpattern;

import java.util.Date;
import java.util.Observable;

/**
 * 观察者
 * 
 * @author ZhangHao
 *
 */
public class Observer {

	/** 被观察者 */
	static class Clock extends Observable {
		
		public void finishClass() {
			System.out.println("off class!!");
			
			setChanged();
			notifyObservers();
		}
		
	}
	
	/** 观察者 */
	static class Student implements java.util.Observer {

		private String name;
		
		Student(Observable ob, String name) {
			this.name = name;
			ob.addObserver(this);
		}
		
		@Override
		public void update(Observable o, Object arg) {
			System.out.println(name + " get out of classroom");
		}
		
	}
	
	public static void main(String[] args) {
		
		Clock clk = new Clock();
		
		Student zs = new Student(clk, "Zhang San");
		Student ls = new Student(clk, "Li Si");
		
		clk.finishClass();
	}
	
}
