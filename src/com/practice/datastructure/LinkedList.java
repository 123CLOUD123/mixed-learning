package com.practice.datastructure;

/**
 * 双向链表
 * 
 * @author Cloud
 */
public class LinkedList<T> {

	private int size;
	
	private Node<T> first;
	
	private Node<T> last;
	
	/**
	 * 节点类
	 */
	private static class Node<T> {
		Node<T> pre;
		Node<T> next;
		T val;
		Node(Node<T> pre, Node<T> next, T val) {
			this.val = val;
			this.pre = pre;
		}
	}

	/**
	 * 添加一个元素
	 */
	public void add(T t) {
		if (first == null) {
			first = last = new Node<T>(null, null, t);
		} else {
			Node<T> newNode = new Node<T>(last, null, t);
			last.next = newNode;
			last = newNode;
		}
		size++;
	}
	
	/**
	 * 删除第一个
	 */
	public void removeFirst() {
		if (size == 0) {
			throw new RuntimeException("无法删除，链表中无元素。");
		}
		
		// 断掉首节点和下个节点的联系以供垃圾回收
		Node<T> next = first.next;
		if (next != null) {
			next.pre = null;
			first.next = null;
			first = next;
		} else {
			first = last = null;
		}
		
		size--;
	}
	
	/**
	 * 删除最后一个
	 */
	public void removeLast() {
		if (size == 0) {
			throw new RuntimeException("无法删除，链表中无元素。");
		}
		
		// 断掉末节点和下个节点的联系以供垃圾回收
		Node<T> pre = last.pre;
		if (pre != null) {
			pre.next = null;
			last.pre = null;
			last = pre;
		} else {
			first = last = null;
		}
		
		size--;
	}
	
	/**
	 * 删除位置i元素
	 */
	public void remove(int i) {
		// 校验是否超过当前大小
		if (i + 1 > size) {
			throw new RuntimeException("无法删除，索引超过链表长度。");
		}
		
		// 对头部、尾部元素直接删除 
		if (i == 0) {
			removeFirst();
			return;
		}
		if (i == size - 1) {
			removeLast();
			return;
		}
		
		// 根据靠近头尾的距离来选择从哪端开始遍历
		Node<T> pre = null, next = null, cur = null;
		if (i <= size / 2) {
			for (int j = 0; j <= i + 1; j++) {
				if (cur == null) {
					cur = first;
				} else {
					cur = cur.next;
				}
				if (j == i - 1) {
					pre = cur;
				}
				if (j == i + 1) {
					next = cur;
				}
			}
		} else {
			for (int j = size - 1; j >= i - 1; j--) {
				if (cur == null) {
					cur = last;
				} else {
					cur = cur.pre;
				}
				if (j == i - 1) {
					pre = cur;
				}
				if (j == i + 1) {
					next = cur;
				}
			}
		}
		if (pre == null || next == null) {
			throw new RuntimeException("删除出错");
		}
		
		// 删除操作
		Node<T> target = pre.next;
		target.pre = target.next = null;
		pre.next = next;
		next.pre = pre;
		
		size--;
	}
	
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		if (size == 0) {
			return "EMPTY";
		}
		
		StringBuilder sb = new StringBuilder();
		Node<T> cur = first;
		sb.append(cur.val);
		
		while (cur.next != null) {
			cur = cur.next;
			sb.append(", " + cur.val);
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		LinkedList<String> l = new LinkedList<String>();
		l.add("hello");
		l.add("world");
		l.add("zhang");
		l.add("hao");
		
		System.out.println(l.size());
		System.out.println(l);
		
		l.remove(1);
		
		System.out.println(l.size());
		System.out.println(l);
	}
}
