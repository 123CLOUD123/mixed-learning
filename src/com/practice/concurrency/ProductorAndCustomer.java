package com.practice.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *   生产者与消费者
 * @author Cloud
 *
 */
public class ProductorAndCustomer {

	private static class Meal {
		private final int orderNum;
		public Meal(int orderNum) {
			this.orderNum = orderNum;
		}
		public String toString() {
			return "Meal " + orderNum;
		}
	}
	
	private static class Restaurant {
		ExecutorService e = Executors.newCachedThreadPool();
		Meal meal;
		WaitPerson waitPerson = new WaitPerson(this);
		Chef chef = new Chef(this);
		Restaurant() {
			e.execute(waitPerson);
			e.execute(chef);
		}
	}
	
	private static class Chef implements Runnable {
		private int count = 0;
		private Restaurant r;
		Chef(Restaurant r) {
			this.r = r;
		}
		@Override
		public void run() {
			try {
				while (!Thread.interrupted()) {
					synchronized(this) {
						while(r.meal != null) {
							wait();
						}
					}
					if (++count == 10) {
						System.out.println("Out of food!!!");
						r.e.shutdownNow();
					}
					System.out.println("Order up!!!");
					synchronized(r.waitPerson) {
						r.meal = new Meal(count);
						r.waitPerson.notifyAll();
					}
					TimeUnit.MILLISECONDS.sleep(100);
				}
			} catch(InterruptedException e) {
				
			}
			
		}
		
	}
	
	private static class WaitPerson implements Runnable {
		private Restaurant r;
		WaitPerson(Restaurant r) {
			this.r = r;
		}
		public void run() {
			try {
				while(!Thread.interrupted()) {
					synchronized(this) {
						while(r.meal == null) {
							wait();
						}
					}
					System.out.println("WaitPerson got meal!!" + r.meal);
					synchronized(r.chef) {
						r.meal = null;
						r.chef.notifyAll();
					}
				}
			} catch(InterruptedException e) {
				System.out.println("WaitPerson end!");
			}
		}
	}
	
	public static void main(String[] args) {
		new Restaurant();
	}
	
}
