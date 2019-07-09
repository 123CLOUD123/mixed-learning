package com.practice.javabase;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 测试自定义注解
 * @author Cloud
 *
 */
public class AnnotationTest {
	
	@FieldConstraint
	private int test1;
	
	@FieldConstraint(description = "字段2的测试")
	public String test2;
	
	public static void main(String[] args) {
		FieldConstraintHandler.handle(AnnotationTest.class);
	}
}


/**
 * 自定义注解
 * 对字段是否私有做限制
 * @author Cloud
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldConstraint {
	String description() default "";
}

/**
 * 注解处理器
 * @author Cloud
 */
class FieldConstraintHandler {
	
	public static void handle(Class<?> cls) {
		Field[] fields = cls.getDeclaredFields();
		for (Field field : fields) {
			FieldConstraint fc = field.getAnnotation(FieldConstraint.class);
			if (fc != null) {
				int mod = field.getModifiers();
				if (!Modifier.isPrivate(mod)) {
					String fieldName = field.getName();
					StringBuilder sb = new StringBuilder();
					sb.append("字段：")
					  .append(fieldName)
					  .append("（描述：")
					  .append(fc.description())
					  .append("）非私有。");
					System.out.println(sb.toString());
				}
			}
		}
	}
	
}

