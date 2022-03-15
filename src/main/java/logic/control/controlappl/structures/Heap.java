package logic.control.controlappl.structures;

import java.util.Arrays;

public class Heap {
	 
	public double[] array;
	
	public Heap(double[] array) {
		this.array = array;
	}
	
	public int getHeapLength() {
		return this.array.length;
	}
	
	public int getIndexChildSx(int i) {
		return 2*i+1;
	}
	
	public int getIndexChildDx(int i) {
		return 2*i+2;
	}
	
	public int getIndexFather(int i) {
		if(i%2 == 0) {
			return i/2 -1;
		} else {
			return (int)i/2;
		}
	}
	
	public Integer getIndexChildMax(int i) {
		int n = this.getHeapLength();
		if(this.getIndexChildDx(i) <= n-1) {
			//the value at index i has two children
			if(array[this.getIndexChildDx(i)] > array[this.getIndexChildSx(i)]) {
				return this.getIndexChildDx(i);
			} else {
				return this.getIndexChildSx(i);
			}
		} else if(this.getIndexChildSx(i) <= n-1) {
			return this.getIndexChildSx(i);
		} else {
			return null;
		}
	}
	
	public Integer getIndexChildMin(int i) {
		int n = this.getHeapLength();
		if(this.getIndexChildDx(i) <= n-1) {
			//the value at index i has two children
			if(array[this.getIndexChildDx(i)] < array[this.getIndexChildSx(i)]) {
				return this.getIndexChildDx(i);
			} else {
				return this.getIndexChildSx(i);
			}
		} else if(this.getIndexChildSx(i) <= n-1) {
			return this.getIndexChildSx(i);
		} else {
			return null;
		}
	}
	
	/*
	 * Desc sorting
	 */
	public void heapifyRecursiveDesc(int first, int last) {
		if(first >= last) {
			return;
		}
		heapifyRecursiveDesc(this.getIndexChildSx(first), last);
		heapifyRecursiveDesc(this.getIndexChildDx(first), last);
		fixHeapDesc(first);
	}
	
	public void heapifyDesc() {
		heapifyRecursiveDesc(0, this.getHeapLength()-1);
	}
	
	public void fixHeapDesc(int v) {
		if(this.getIndexChildMax(v) == null) {
			return;
		} else {
			int u = this.getIndexChildMax(v);
			if(array[v] < array[u]) {
				double temp = array[v];
				array[v] = array[u];
				array[u] = temp;
				fixHeapDesc(u);
			}
		}
		
	}
	
	public double removeMax() {
		double max = this.array[0];
		this.array[0] = this.array[this.getHeapLength()-1];
		this.array[this.getHeapLength()-1] = max;
		this.array = Arrays.copyOfRange(array, 0, this.getHeapLength()-1);
		this.fixHeapDesc(0);
		return max;
	}
	
	/*
	 * Asc sorting
	 */
	public void heapifyRecursiveAsc(int first, int last) {
		if(first >= last) {
			return;
		}
		heapifyRecursiveAsc(this.getIndexChildSx(first), last);
		heapifyRecursiveAsc(this.getIndexChildDx(first), last);
		fixHeapAsc(first);
	}
	
	public void heapifyAsc() {
		heapifyRecursiveAsc(0, this.getHeapLength()-1);
	}
	
	public void fixHeapAsc(int v) {
		if(this.getIndexChildMax(v) == null) {
			return;
		} else {
			int u = this.getIndexChildMin(v);
			if(array[v] > array[u]) {
				double temp = array[v];
				array[v] = array[u];
				array[u] = temp;
				fixHeapAsc(u);
			}
		}
		
	}
	
	public double removeMin() {
		double min = this.array[0];
		this.array[0] = this.array[this.getHeapLength()-1];
		this.array[this.getHeapLength()-1] = min;
		this.array = Arrays.copyOfRange(array, 0, this.getHeapLength()-1);
		this.fixHeapAsc(0);
		return min;
	}
	
	/**
	 * debug methods
	 */
	public void checkHeapDesc() {
		int i=0;
		while(this.getIndexChildMax(i)!=null) {
			double parent = array[i];
			double childSx = array[this.getIndexChildSx(i)];
			if(parent < childSx) {
				System.out.println("\nError heapify - value: " + array[i] + " - index: " + i);
				return;
			}
			if(this.hasChildDx(i)) {
				double childDx = array[this.getIndexChildDx(i)];
				if(parent < childDx) {
				System.out.println("\nError heapify - value: " + array[i] + " - index: " + i);
				return;
				}
			}
			i++;
		}
		System.out.println("\n\nHeapify is correct");
	}
	
	public void checkHeapAsc() {
		int i=0;
		while(this.getIndexChildMax(i)!=null) {
			double parent = array[i];
			double childSx = array[this.getIndexChildSx(i)];
			if(parent > childSx) {
				System.out.println("\nError heapify - value: " + array[i] + " - index: " + i);
				return;
			}
			if(this.hasChildDx(i)) {
				double childDx = array[this.getIndexChildDx(i)];
				if(parent > childDx) {
				System.out.println("\nError heapify - value: " + array[i] + " - index: " + i);
				return;
				}
			}
			i++;
		}
		System.out.println("\n\nHeapify is correct");
	}
	
	public boolean hasChildDx(int i) {
		if(this.getIndexChildDx(i) < this.getHeapLength()) {
			return true;
		} else {
			return false;
		}
	}
	
}
