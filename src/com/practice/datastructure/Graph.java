package com.practice.datastructure;

import java.util.List;

/**
 * @author ZhangHao
 * 
 * 邻接表图
 */
public class Graph {

	// 顶点数量
	private int v;
	
	// 边数量
	private int e;
	
	// 邻接表
	private LinkedList<Integer>[] data;
	
	Graph(int v) {
		this.v = v;
		data = new LinkedList[v];
		for (LinkedList<Integer> element : data) {
			element = new LinkedList<Integer>();
		}
	}
	
	/**
	 * 添加一條边
	 */
	public void addEdge(int v, int w) {
		data[v].add(w);
		data[w].add(v);
		e++;
	}
	
	/**
	 * 获取相邻顶点
	 */
	public LinkedList<Integer> getNeighborV(int v) {
		return data[v];
	}
	
	/**
	 * 获取顶点数
	 */
	public int getV() {
		return v;
	}
	
	/**
	 * 获取边数
	 */
	public int getE() {
		return e;
	}
	
}
