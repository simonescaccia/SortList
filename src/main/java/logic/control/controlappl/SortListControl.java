package logic.control.controlappl;

import java.util.ArrayList;
import java.util.List;

import logic.control.bean.ListBean;
import logic.control.bean.ResponseListBean;
import logic.control.controlappl.structures.Heap;

public class SortListControl {
	
	public ResponseListBean sortList(ListBean listBean) {
		
		//sort list
		switch(listBean.getAlgorithmType()) {
		case 0:
			return heapsort(listBean);
		case 1:
			return mergesort(listBean);
		case 2:
			return quicksort(listBean);
		case 3:
			return bubblesort(listBean);
		case 4:
			return selectionsort(listBean);
		case 5: 
			return insertionsort(listBean);
		default:
			return heapsort(listBean);
		}
		
	}
	
	protected ResponseListBean heapsort(ListBean listBean) {
		//create the response bean
		ResponseListBean rLB = new ResponseListBean(listBean);
		
		double[] array = rLB.getListBean().getNumbersList().clone();
		if(listBean.getOrderType()) {
			rLB.setNumbersList(ascHeapSort(array));
		} else {
			rLB.setNumbersList(descHeapSort(array));
		}
		
		return rLB;
	}
	
	protected ResponseListBean mergesort(ListBean listBean) {
		//create the response bean
		ResponseListBean rLB = new ResponseListBean(listBean);
		
		//dummy sort
		rLB.setNumbersList(rLB.getListBean().getNumbersList());
		
		return rLB;
	}
	
	protected ResponseListBean bubblesort(ListBean listBean) {
		//create the response bean
		ResponseListBean rLB = new ResponseListBean(listBean);
		
		double[] array = rLB.getListBean().getNumbersList().clone();
		if(listBean.getOrderType()) {
			rLB.setNumbersList(ascBubbleSort(array));
		} else {
			rLB.setNumbersList(descBubbleSort(array));
		}
		
		return rLB;
	}
	
	protected ResponseListBean quicksort(ListBean listBean) {
		//create the response bean
		ResponseListBean rLB = new ResponseListBean(listBean);
		
		//dummy sort
		rLB.setNumbersList(rLB.getListBean().getNumbersList());
		
		return rLB;
	}
	
	protected ResponseListBean selectionsort(ListBean listBean) {
		//create the response bean
		ResponseListBean rLB = new ResponseListBean(listBean);
		
		double[] array = rLB.getListBean().getNumbersList().clone();
		if(listBean.getOrderType()) {
			rLB.setNumbersList(ascSelectionSort(array));
		} else {
			rLB.setNumbersList(descSelectionSort(array));
		}

		return rLB;
	}
	
	protected ResponseListBean insertionsort(ListBean listBean) {
		//create the response bean
		ResponseListBean rLB = new ResponseListBean(listBean);
		
		double[] array = rLB.getListBean().getNumbersList().clone();
		if(listBean.getOrderType()) {
			rLB.setNumbersList(ascInsertionSort(array));
		} else {
			rLB.setNumbersList(descInsertionSort(array));
		}

		return rLB;
	}
	
	/**
	 * Implementation of sorting algorithms
	 */

	/*
	 * HeapSort
	 */
	protected double[] descHeapSort(double[] array) {
		
		Heap h = new Heap(array);
		List<Double> arrayOrdered = new ArrayList<Double>();
		h.heapifyDesc();
		while(h.getHeapLength() > 0) {
			arrayOrdered.add(h.removeMax());
		}
		return arrayOrdered.stream().mapToDouble(d -> d).toArray();
	}
	
	protected double[] ascHeapSort(double[] array) {
		
		Heap h = new Heap(array);
		List<Double> arrayOrdered = new ArrayList<Double>();
		h.heapifyAsc();
		while(h.getHeapLength() > 0) {
			arrayOrdered.add(h.removeMin());
		}
		return arrayOrdered.stream().mapToDouble(d -> d).toArray();
	}
	
	/*
	 * SelectionSort
	 */
	protected double[] ascSelectionSort(double[] array) {
		int n = array.length;
		//m e k due indici
		for(int k=0; k<=n-2; k++) {
			//min è il l'indice del minimo
			int min = k;
			for(int j=k+1; j<=n-1; j++) {
				if(array[j] < array[min]) {
					min = j;
				}
			}
			//scambia array[m] con array[k+1]
			double temp = array[min];
			array[min] = array[k];
			array[k] = temp;
		}
		
		return array;
	}
	
	protected double[] descSelectionSort(double[] array) {
		int n = array.length;
		//m e k due indici
		for(int k=0; k<=n-2; k++) {
			//max è il l'indice del massimo
			int max = k;
			for(int j=k+1; j<=n-1; j++) {
				if(array[j] > array[max]) {
					max = j;
				}
			}
			//scambia array[m] con array[k+1]
			double temp = array[max];
			array[max] = array[k];
			array[k] = temp;
		}
		
		return array;
	}

	/*
	 * InsertionSort
	 */
	protected double[] ascInsertionSort(double[] array) {
		int n = array.length;
		for(int i = 1;i < n;i++) {
			double value = array[i];
			int j;
			for(j=i-1; j>=0; j--) {
				if(value > array[j]) {
					//value index should be j + 1
					break;
				}
			}
			//right shift of numbers from [j+1, i-1] to [j+2, i]
			for(int k=i-1; k>=j+1; k--) {
				array[k+1] = array[k];
			}
			array[j+1] = value;
		}
		
		return array;
	}
	
	protected double[] descInsertionSort(double[] array) {
		int n = array.length;
		for(int i = 1;i < n;i++) {
			double value = array[i];
			int j;
			for(j=i-1; j>=0; j--) {
				if(value < array[j]) {
					//value index should be j + 1
					break;
				}
			}
			//right shift of numbers from [j+1, i-1] to [j+2, i]
			for(int k=i-1; k>=j+1; k--) {
				array[k+1] = array[k];
			}
			array[j+1] = value;
		}
		
		return array;
	}
	
	/*
	 * BubbleSort
	 */
	protected double[] ascBubbleSort(double[] array) {
		int n = array.length;
		for(int i=1; i<n; i++) {
			boolean scambi = false;
			for(int j=1; j<n-i+1; j++) {
				if(array[j-1] > array[j]) {
					//switch array[j-1] e array[j] 
					double temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
					scambi = true;
				}
			}
			if(!scambi) {
				//the list is alredy ordered
				break;
			}
		}
		
		return array;
	}
	
	protected double[] descBubbleSort(double[] array) {
		int n = array.length;
		for(int i=1; i<n; i++) {
			boolean scambi = false;
			for(int j=1; j<n-i+1; j++) {
				if(array[j-1] < array[j]) {
					//switch array[j-1] e array[j] 
					double temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
					scambi = true;
				}
			}
			if(!scambi) {
				//the list is alredy ordered
				break;
			}
		}
		
		return array;
	}
}
