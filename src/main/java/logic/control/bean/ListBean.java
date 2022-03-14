package logic.control.bean;

import logic.exception.AlgorithmTypeException;
import logic.exception.NumbersSequenceSplitException;
import logic.exception.OrderTypeException;

public class ListBean {
	private double numbersList[];
	private boolean orderType;
	private int algorithmType;
	private String time;
	
	public ListBean(String numbersList, String orderType, String algorithmType) throws NumbersSequenceSplitException, AlgorithmTypeException, OrderTypeException {
		this.setNumbersList(numbersList);
		this.setAlgorithmType(algorithmType);
		this.setOrderType(orderType);
	}
	
	public void setNumbersList(String numbersList) throws NumbersSequenceSplitException {
		//check empty string
		if(numbersList == null || numbersList.isEmpty() || numbersList.isBlank()) {
			String message = "Empty list";
			throw new NumbersSequenceSplitException(message);
		}
		
		//string split
		String[] split = numbersList.split(" ");
		
		//convert string to double
		this.numbersList = new double[split.length];
		for(int i = 0; i < split.length; i++) {
			try {
				
				this.numbersList[i] = Double.parseDouble(split[i]);
				
			} catch (NullPointerException e) {
				String message = e.getMessage() + " at index " + i;
				throw new NumbersSequenceSplitException(message, e.getCause());
			} catch (NumberFormatException e) {
				String message = e.getMessage() + " at index " + i;
				throw new NumbersSequenceSplitException(message, e.getCause());
			}
		}
	}
	
	public double[] getNumbersList() {
		return this.numbersList;
	}
	
	public String printNumbersList() {
		int length = this.numbersList.length;
		String[] strResultList = new String[length];
		for(int i = 0; i < length; i++) {
			strResultList[i] = Double.toString(this.numbersList[i]); 
		}
		return String.join(" ", strResultList);
	}
	
	public void setOrderType(String orderType) throws OrderTypeException {
		switch(orderType) {
		case "asc":
			this.orderType = true;
			break;
		case "desc":
			this.orderType = false;
			break;
		default:
			String message = "Order type should be one of the following: Asc, Desc";
			throw new OrderTypeException(message);
		}
	}
	
	public boolean getOrderType() {
		return orderType;
	}
	
	public String printOrderType() {
		if(this.orderType) {
			return "asc";
		} else {
			return "desc";
		}
	}
	
	public void setAlgorithmType(String algorithmType) throws AlgorithmTypeException {
		switch(algorithmType) {
		case "heapsort":
			this.algorithmType = 0;
			break;
		case "mergesort":
			this.algorithmType = 1;
			break;
		case "quicksort":
			this.algorithmType = 2;
			break;
		case "bubblesort":
			this.algorithmType = 3;
			break;
		case "selectionsort":
			this.algorithmType = 4;
			break;
		default:
			String message = "Algorithm type should be one of the following: HeapSort, MergeSort, QuickSort, BubbleSort";
			throw new AlgorithmTypeException(message);
		}
	}
	
	public int getAlgorithmType() {
		return algorithmType;
	}	
	
	public String printAlgorithmType() {
		switch(this.algorithmType) {
		case 0:
			return "heapsort";
		case 1:
			return "mergesort";
		case 2:
			return "quicksort";
		case 3:
			return "bubblesort";
		case 4:
			return "selectionsort";
		case 5:
			return "insertionsort";	
		default:
			return "heapsort";
		}
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getTime() {
		return time;
	}
}
