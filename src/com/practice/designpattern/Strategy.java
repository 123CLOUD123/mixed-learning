package com.practice.designpattern;


/**
 * 策略
 * @author Cloud
 *
 */
public class Strategy {

	public void driveF(StraInterface st) {
		st.f();
	}
	
}

interface StraInterface {
	
	void f();
}

class Stra1 implements StraInterface {

	@Override
	public void f() {
		// TODO Auto-generated method stub
		
	}
	
}

class Stra2 implements StraInterface {

	@Override
	public void f() {
		// TODO Auto-generated method stub
		
	}
	
}

