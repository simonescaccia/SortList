package logic.control.controlappl.structures_algorithms;

public class MergeSort {
	
	private double[] array;
	
	public MergeSort(double[] array) {
		this.array = array;
	}
	
	public int getArrayLength() {
		return this.array.length;
	}
	
	public double[] getArray() {
		return this.array;
	}
	
	public void copyArray(double temp[], int i, int f) {
		//copy temp in array
		int j=0;
		for(int k=i; k<=f; k++) {
			array[k] = temp[j];
			j++;
		}
	}
	
	/*
	 * mergesort asc
	 */
	public void mergesortAsc(int i, int f) {
		if(i >= f) {
			return;
		}
		int m = (i + f)/2;
		mergesortAsc(i, m);
		mergesortAsc(m+1, f);
		mergeAsc(i, m, f);
	}
	
	protected void mergeAsc(int i, int m, int f) {
		int i1 = i;
		int f1 = m;
		int i2 = m+1;
		int f2 = f;
		
		int j = 0;
		int len = f-i+1;
		double[] temp = new double[len]; 

		while(i1<=f1 || i2<=f2) {
			if(i1<=f1 && i2>f2) {
				temp[j] = array[i1];
				i1++;
			} else if(i1>f1 && i2<=f2) {
				temp[j] = array[i2];
				i2++;
			} else if(i1<=f1 && i2<=f2 && array[i1] < array[i2]) {
				temp[j] = array[i1];
				i1++;
			} else {
				temp[j] = array[i2];
				i2++;
			}
			j++;
		}
		
		copyArray(temp, i ,f);
	}
	
	/*
	 * mergesort desc
	 */
	public void mergesortDesc(int i, int f) {
		if(i >= f) {
			return;
		}
		int m = (i + f)/2;
		mergesortDesc(i, m);
		mergesortDesc(m+1, f);
		mergeDesc(i, m, f);
	}
	
	protected void mergeDesc(int i, int m, int f) {
		int i1 = i;
		int f1 = m;
		int i2 = m+1;
		int f2 = f;
		
		int j = 0;
		int len = f-i+1;
		double[] temp = new double[len]; 

		while(i1<=f1 || i2<=f2) {
			if(i1<=f1 && i2>f2) {
				temp[j] = array[i1];
				i1++;
			} else if(i1>f1 && i2<=f2) {
				temp[j] = array[i2];
				i2++;
			} else if(i1<=f1 && i2<=f2 && array[i1] > array[i2]) {
				temp[j] = array[i1];
				i1++;
			} else {
				temp[j] = array[i2];
				i2++;
			}
			j++;
		}
		
		copyArray(temp, i ,f);
	}
}
