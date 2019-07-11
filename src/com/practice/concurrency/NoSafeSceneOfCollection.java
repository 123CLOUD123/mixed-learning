package com.practice.concurrency;

import java.util.Vector;

/**
 * 线程不安全的场景
 * @author Cloud
 *
 */
public class NoSafeSceneOfCollection {

	// Vector采用同步的方式实现线程安全性
	private static Vector<Integer> v;
	
	NoSafeSceneOfCollection() {
		
		//对容器进行初始化
		
	}
	
	//不安全的线程操作
	//先获取容器长度，再根据长度获取或删除最后一个元素，在这两步操作之间可能会被其他线程修改
//	public static int getLast() {
//		int len = v.size();
//		return v.get(len - 1);
//	}
//	
//	public static void removeLast() {
//		int len = v.size();
//		v.remove(len - 1);
//	}
	
	
	// 可通过同步控制块的方式，使用容器对象来给块操作进行加锁，从而实现线程安全
	public static int getLast() {
		synchronized(v) {
			int len = v.size();
			return v.get(len - 1);
		}
	}

	public static void removeLast() {
		synchronized(v) {
			int len = v.size();
			v.remove(len - 1);
		}
	}
	
	public static void main() {
		new Thread(() -> { 
			getLast();
		}).start();
		new Thread(() -> { 
			removeLast();
		}).start();
	}
}
