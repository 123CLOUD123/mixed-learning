package com.practice.concurrency;

/**
 * 多线程共享可变变量时，可通过ThreadLocal来实现线程安全，ThreadLocal类通过为每个线程创建一个与该线程相关联
 * 的ThreadLocalMap来存储线程要访问的变量，这样的方式改杜绝了共享的行为，改成线程封闭的方式来访问变量，变量不
 * 被共享了，也就一定是线程安全的了
 * @author Cloud
 *
 */
public class NotSafetySolution3 {

//	private static Long count;
	private static ThreadLocal<Long> countHolder = new ThreadLocal<Long>() {
		public Long initValue() {
			return 0L;
		}
	};
	
	public static void changeCount() {
		countHolder.set(countHolder.get() + 1);
	}
	
}
