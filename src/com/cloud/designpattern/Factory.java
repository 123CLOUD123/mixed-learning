package com.cloud.designpattern;

/**
 * 工厂模式
 * @author Cloud
 *
 */
public class Factory implements IFactory{

	public <T extends Product> Product generateProduct(Class<T> cls) {
		Product p = null;
		try {
			p = cls.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public static void main(String[] args) {
		Factory f = new Factory();
		Product p1 = f.generateProduct(Toy.class);
		p1.printInfo();
		Product p2 = f.generateProduct(Bag.class);
		p2.printInfo();
	}
}


interface IFactory {
	<T extends Product> Product generateProduct(Class<T> cls);
}

interface Product {
	void printInfo();
}

class Toy implements Product {

	private String info = "I am toy";
	
	@Override
	public void printInfo() {
		System.out.println(info);
	}
	
}

class Bag implements Product {
	
	private String info = "I am bag";
	
	@Override
	public void printInfo() {
		System.out.println(info);
	}
}