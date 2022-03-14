package test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import logic.control.bean.ListBean;
import logic.control.bean.ResponseListBean;
import logic.control.controlappl.SortListControl;
import logic.exception.AlgorithmTypeException;
import logic.exception.NumbersSequenceSplitException;
import logic.exception.OrderTypeException;

public class TestSortListControl {

	private String testSequence = "5 7 2 4 8 4 2 3 6 3 1 8 3 6 44 3 6 8 5 2";
	private String[] algorithms = {"heapsort", "mergesort", "quicksort", "bubblesort", "selectionsort", "insertionsort"};
	private String[] orders = {"asc", "desc"};
	
	@Test
	public void testSortList() throws NumbersSequenceSplitException, AlgorithmTypeException, OrderTypeException {
		
		boolean condAssert = true;
		for(int i=0; i<this.algorithms.length; i++) {
			for(int j=0; j<this.orders.length; j++) {
				//get ordered list
				ListBean lB = new ListBean(testSequence, orders[j], algorithms[i]);
				SortListControl sLC = new SortListControl();
				ResponseListBean rLB = sLC.sortList(lB);
				//check ordered list
				boolean cond;
				if(orders[j].equals("asc")) {
					cond = this.checkOrderAsc(rLB);
				} else {
					cond = this.checkOrderDesc(rLB);
				}
				//debug: print result
				if(!cond) {
					System.err.print(cond); 
				} else {
					System.out.print(cond);
				}
				System.out.print(" - " + algorithms[i]+ " - " + orders[j] + ": ");
				for(int k=0; k<rLB.getNumbersList().length; k++) {
					System.out.print(rLB.getNumbersList()[k] + " ");
				}
				System.out.println(" ");
				condAssert = condAssert && cond;
			}
			System.out.println(" ");
		}
			
		assertTrue(condAssert);
		
	}
	
	private boolean checkOrderAsc(ResponseListBean rLB) {
		for(int k=1; k<rLB.getNumbersList().length; k++) {
			if(rLB.getNumbersList()[k] < rLB.getNumbersList()[k-1]) {
				return false;
			}
		}
		return true;
	}
	
	private boolean checkOrderDesc(ResponseListBean rLB) {
		for(int k=1; k<rLB.getNumbersList().length; k++) {
			if(rLB.getNumbersList()[k] > rLB.getNumbersList()[k-1]) {
				return false;
			}
		}
		return true;
	}
}
