package com.practice.javabase;

/**
 * 测试接口中的字段自动是public static final
 * @author Cloud
 *
 */
public class AboutInterface {

	public static void main(String[] args) {
		
		//编译不通过，提示final域
//		TestInterface.s = "hello";  
		
		// 可通过接口名称引用变量
		// 思考：接口不可被实例化，所以其中的字段只能在虚拟机加载的时候被读取并保存在虚拟机中，所以只能应该是static
		System.out.println(TestInterface.s);
	}
	
}

interface TestInterface {
	
	//加private编译不通过，提示only public
//	private String s = "test";
	
	String s = "test";
}
