package com.practice.designpattern;

/**
 * 模板方法
 * @author Cloud
 *
 */
public abstract class Template {
	
	protected abstract void methodToExtends();
	
	public final void methodDefault() {
		
		//do something
		
	}
}

class ConcreteClass extends Template {

	@Override
	protected void methodToExtends() {
	
		
		
	}
	
}
