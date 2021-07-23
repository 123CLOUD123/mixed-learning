package com.practice.util;

import java.util.Arrays;

public class DataUtil {

	public static int[] genIntArray(int size, int max) {
		int[] result = new int[size];
		for (int i = 0; i < size; i++) {
			int num = (int) (Math.random() * max);
			result[i] = num;
		}
		return result;
	}
	
	public static void swap(int[] input, int i, int j) {
		if (i == j) {
			return;
		}
		input[i] = input[i] + input[j];
		input[j] = input[i] - input[j];
		input[i] = input[i] - input[j];
	}
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 40, 5};
		swap(a, 3, 3);
		System.out.println(Arrays.toString(a));
	}
	
}