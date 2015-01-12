package com.shop.utils;

public class Paginate {

	private int start = 0;
	private int max = 50;
	private int total;

	public Paginate(int total) {
		if (total < max) {
			max = total;
		}
		this.total = total;
	}

	public int next() {
		start = start + 50;
		max = total < max + 50 ? max + 50 : total;
		return start;
	}
	
	public int previous(){
		start = start - 50;
		max = total > max - 50 ? max - 50 : total;
		return start;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
