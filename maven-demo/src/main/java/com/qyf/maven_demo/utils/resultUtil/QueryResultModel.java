package com.qyf.maven_demo.utils.resultUtil;


public class QueryResultModel<T> extends ResultModel{
	
	private Integer total;
	private T rows;
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public T getRows() {
		return rows;
	}
	public void setRows(T rows) {
		this.rows = rows;
	}
	

}

