package com.practice.concurrency;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 只有一个可被多个线程共享的变量时，可通过将该变量由一个线程安全类来代替以实现线程安全
 * @author Cloud
 *
 */
public class NotSafetySolution1 {

	/*
	 * 原来的count是Long类型，对它执行递增操作，会存在读到内存-》修改-》写回内存的多个操作，在任意操作阶段都可能被
	 * 调度，从而导致不正确的后果，修改为AtomicLong后，这些多个操作变为了原子操作，从而实现线程安全
	 */
//	private static Long count;
	private static AtomicLong count = new AtomicLong(0);
	
	public static void changeCount() {
//		count++;
		count.incrementAndGet();
	}
	
}
