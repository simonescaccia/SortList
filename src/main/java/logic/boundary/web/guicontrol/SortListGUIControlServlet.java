package logic.boundary.web.guicontrol;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logic.control.bean.ListBean;
import logic.control.bean.ResponseListBean;
import logic.control.controlappl.SortListControl;
import logic.exception.*;

public class SortListGUIControlServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet (HttpServletRequest req, HttpServletResponse resp) {
		
		//get parameters from index.jsp
		String numbersSequence = req.getParameter("numbersSequence");
		String algorithm = req.getParameter("algorithm");
		String order = req.getParameter("order");
		
		String stringResult = null;
		ListBean listBean = null;
		
		//fill ListBean
		try {
			listBean = new ListBean(numbersSequence, order, algorithm);  
		} catch (AlgorithmTypeException |NumbersSequenceSplitException | OrderTypeException e) {
			stringResult = e.getMessage();
		}
		
		//sort list
		boolean flagException = true;
		if(stringResult == null) {
			flagException = false;
			SortListControl sortListControl = new SortListControl();
			ResponseListBean responseListBean = sortListControl.sortList(listBean);
			stringResult = responseListBean.printNumbersList();
			req.setAttribute("strRequest", responseListBean.getListBean().printNumbersList());
			req.setAttribute("strOrder", responseListBean.getListBean().printOrderType());
			req.setAttribute("strAlgorithm", responseListBean.getListBean().printAlgorithmType());

		}
		
		RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
		req.setAttribute("strResult", stringResult);
		//refill input
		if(flagException) {
			req.setAttribute("strRequest", req.getParameter("numbersSequence"));
			req.setAttribute("strOrder", req.getParameter("order"));
			req.setAttribute("strAlgorithm", req.getParameter("algorithm"));
		}
		
    	try {
			rd.forward(req, resp);
		} catch (jakarta.servlet.ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
