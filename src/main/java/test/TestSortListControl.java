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

	@Test
	public void testSortList() throws NumbersSequenceSplitException, AlgorithmTypeException, OrderTypeException {
		
		String testSequence = "5 7 2 4 8 4";
		String algorithm = "selectionsort";
		String order = "desc";
		
		ListBean lB = new ListBean(testSequence, order, algorithm);
		SortListControl sLC = new SortListControl();
		ResponseListBean rLB = sLC.sortList(lB);

		boolean cond = true;
		for(int i=1; i<rLB.getNumbersList().length; i++) {
			if(rLB.getNumbersList()[i] < rLB.getNumbersList()[i-1]) {
				cond = false;
				break;
			}
		}
		
		for(int i=0; i<rLB.getNumbersList().length; i++) {
			System.out.print(rLB.getNumbersList()[i] + " ");
		}
		
		assertTrue(cond);
		
	}
}
