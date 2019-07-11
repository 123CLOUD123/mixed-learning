package com.practice.javabase;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射的使用
 * @author Cloud
 *
 */
public class PracticeReflect {

	public static void main(String[] args)  {
		Method m;
		try {
			m = Pra.class.getMethod("test", String.class);
			if (m != null) {
				try {
					m.invoke(Pra.class.newInstance(), "world");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}


class Pra {
	
	public void test(String s) {
		System.out.println("hello " + s);
	}
	
}
