package com.practice.concurrency;

import java.util.concurrent.CountDownLatch;

/**
 * 闭锁的使用
 * <p>模拟上课后，等班长说起立，再同学们说老师好后开始正式上课<p>
 * 
 * @author Cloud
 */
public class CountDownLatchTest {

	private static CountDownLatch startClassGate = new CountDownLatch(2);
	
	private static CountDownLatch monitorGate = new CountDownLatch(1);
	
	// 班长起立线程
	private static Thread monitorThread = new Thread() {
		@Override
		public void run() {
			System.out.println("上课，起立！！！！");
			monitorGate.countDown();
			startClassGate.countDown();
		}
	};
	
	// 其餘同學线程
	private static Thread classThread = new Thread() {
		@Override
		public void run() {
			try {
				monitorGate.await();
				System.out.println("老----师----好！！！！");
				startClassGate.countDown();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};
	
	// 老师线程
	private static Thread teacherThread = new Thread() {
		@Override
		public void run() {
			try {
				startClassGate.await();
				System.out.println("坐下！！下面开始上课！！！！");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};
	
	public static void main(String[] args) {
		teacherThread.start();
		monitorThread.start();
		classThread.start();
	}
}
