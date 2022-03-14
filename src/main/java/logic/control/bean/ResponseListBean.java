package logic.control.bean;

public class ResponseListBean {
	private double numbersList[];
	private String time;
	private ListBean requestListBean;
	
	public ResponseListBean(ListBean requestListBean) {
		this.requestListBean = requestListBean;
	}
	
	public void setNumbersList(double numbersList[]) {
		this.numbersList = numbersList;
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
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getTime() {
		return this.time;
	}
	
	public void setRequestBean(ListBean requestListBean) {
		this.requestListBean = requestListBean;
	}
	
	public ListBean getListBean() {
		return this.requestListBean;
	}
}
