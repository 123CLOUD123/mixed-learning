package com.practice.algorithm;

import java.util.Arrays;

import com.practice.util.DataUtil;

/**
 * 
 * @author ZhangHao
 *
 */
public class InsectionSort {

	public static int[] sort(int[] input) {
		int len = input.length;
		for (int i = 2; i < len; i++) {
			for (int j = i; j > 0; j--) {
				if (input[j] < input[j - 1]) {
					DataUtil.swap(input, j, j - 1);
				}
			}
		}
		return input;
	}
	
	public static void main(String[] args) {
		int[] input = DataUtil.genIntArray(100, 100);
		System.out.println(Arrays.toString(input));
		sort(input);
		System.out.println(Arrays.toString(input));
	}
	
}
