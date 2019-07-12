package com.practice.designpattern;

/**
 * 代理
 * @author Cloud
 *
 */
public class Proxy {

	ProTest pt;
	
	Proxy(ProTest pt) {
		this.pt = pt;
	}
	
	public void f() {
		pt.f();
	}
	
}

class ProTest {
	
	public void f() {
		
	}
	
}
