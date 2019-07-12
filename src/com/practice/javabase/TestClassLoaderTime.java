package com.practice.javabase;

/**
 * 测试类加载初始化时机
 * @author Cloud
 *
 */
public class TestClassLoaderTime {

	public static void main(String[] args) {
		
		//通过子类调用父类中的静态方法，只会初始化父类，而不会初始化子类
		Sub.pf();
		Sub.bf();
		
		// 定义并初始化对象数组，不会引起对应的类的加载初始化
		Sub[] s = new Sub[10];
		
		// 引用编译期常量，不会引起类的加载初始化
		int a = Sup.TEST;
		int b = Sup.TEST2;
	}
	
}


class Sup {
	public static final int TEST = 5;
	public static int TEST2 = 6;
	static {
		System.out.println("Sup");
	}
	public static void pf() {
		System.out.println("Sup f()");
	}
}
class Sub extends Sup {
	static {
		System.out.println("Sub");
	}
	public static void bf() {
		System.out.println("Sup f()");
	}
}