package com.practice.algorithm;

import java.util.Arrays;

import com.practice.util.DataUtil;

/**
 * 选择排序
 * @author ZhangHao
 */
public class SelectionSort {

	public static int[] sort(int[] input) {
		int len = input.length;
		for (int i = 0; i < len - 1; i++) {
			int min = i;
			for (int j = i + 1; j < len; j++) {
				if (input[j] < input[min]) {
					min = j;
				}
			}
			DataUtil.swap(input, min , i);
		}
		return input;
	}
	
	public static void main(String[] args) {
		int[] input = DataUtil.genIntArray(100, 100);
		System.out.println(Arrays.toString(input));
		input = sort(input);
		System.out.println(Arrays.toString(input));
	}
	
}
