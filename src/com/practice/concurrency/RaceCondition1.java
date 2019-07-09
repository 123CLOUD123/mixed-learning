package com.practice.concurrency;

/**
 * 线程不安全的情景1 竞态条件 -- 先检查后执行
 * 
 * @author Cloud
 *
 */
public class RaceCondition1 {

	private static LazyInitObj obj;

	// 通过公有方法将私有变量发布
	public static void test() {
		if (obj == null) {
			Thread.yield();
			obj = new LazyInitObj();
		}
	}

	public static void main(String[] args) {

		//第一个线程尝试初始化共享对象
		new Thread(() -> {
			RaceCondition1.test();
		}).run();
		
		//第二个线程尝试初始化共享对象
		new Thread(() -> {
			RaceCondition1.test();
		}).run();

	}
}


class LazyInitObj {
	LazyInitObj() {
		System.out.println("本对象已被初始化。");
	}
}
