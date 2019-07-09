package com.practice.concurrency;

/**
 * 通过同步的方式可实现原子操作，从而实现线程安全的修改
 * @author Cloud
 */
public class NotSafetySolution2 {

	private static Long count;
	
	public synchronized static void changeCount() {
		count++;
	}
	
}
