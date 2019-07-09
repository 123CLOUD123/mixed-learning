package com.practice.javabase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 流的使用
 * @author Cloud
 *
 */
public class StreamTest {

	//随机获取100以内的整数，取得其中大于50的元素，再将他们全部翻倍，最后将他们中的10个以逆序返回
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			l.add((int) (Math.random() * 100));
		}
		List<Integer> l2 = l.stream()
							.filter(a -> a > 50)
							.map(a -> a * 2)
							.limit(10)
							.sorted((a, b) -> b - a)
							.collect(Collectors.toList());
		System.out.println(l2);
	}
	
}
