package com.practice.javabase;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 * @author Cloud
 *
 */
public class PracitceProxy {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		
		Audience aud = new Audience();
		
		InvocationHandler handler = new AudProxy(aud);
		
		ClassLoader cl = aud.getClass().getClassLoader();
		
		Tt proxy = (Tt)Proxy.newProxyInstance(cl, new Class[] {Tt.class}, handler);
		proxy.perform();
		
	}
	
}

interface Tt {
	void perform();
}
class Audience implements Tt{
	
	public void perform() {
		System.out.println("watching performance.");
	}
	
}

class AudProxy implements InvocationHandler {

	Object obj;
	
	AudProxy(Object obj) {
		this.obj = obj;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		Object result = method.invoke(this.obj, args);
		return result;
	}
	
	
}
