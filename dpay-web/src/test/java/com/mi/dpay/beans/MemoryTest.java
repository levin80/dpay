package com.mi.dpay.beans;

import java.util.ArrayList;
import java.util.List;

public class MemoryTest {
	public static void main(String[] args) {
		new Thread(new MemoryLeak(), "MemoryLeak").start();
	}
}

class MemoryLeak implements Runnable {
	public static List<Integer> leakList = new ArrayList<Integer>();

	public void run() {
		int num = 0;
		while (true) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
			num++;
			Integer i = new Integer(num);
			leakList.add(i);

		}
	}
}