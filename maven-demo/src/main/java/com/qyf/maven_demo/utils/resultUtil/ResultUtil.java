package com.qyf.maven_demo.utils.resultUtil;

public class ResultUtil {
	
	public static <T> QueryResultModel<T> success(Integer total, T t){
		QueryResultModel<T> rm =  new QueryResultModel<>();
		rm.setCode(1);
		rm.setInfo("查询成功");
		rm.setTimestamp(System.currentTimeMillis());
		rm.setTotal(total);
		rm.setRows(t);
		return rm;
	}
	
	public static <T> QueryResultModel<T> success(Integer total, T t, String msg){
		QueryResultModel<T> rm =  new QueryResultModel<>();
		rm.setCode(1);
		rm.setInfo(msg);
		rm.setTimestamp(System.currentTimeMillis());
		rm.setTotal(total);
		rm.setRows(t);
		return rm;
	}
	
	public static ResultModel success(String msg){
		ResultModel rm =  new ResultModel();
		rm.setCode(1);
		rm.setInfo("请求成功：" + msg);
		rm.setTimestamp(System.currentTimeMillis());
		return rm;
	}
	
	public static ResultModel fail(String msg){
		ResultModel rm =  new ResultModel();
		rm.setCode(0);
		rm.setInfo("请求失败：" + msg);
		rm.setTimestamp(System.currentTimeMillis());
		return rm;
	}
	
	public static ResultModel fail(Integer code, String msg){
		ResultModel rm =  new ResultModel();
		rm.setCode(code);
		rm.setInfo("请求失败：" + msg);
		rm.setTimestamp(System.currentTimeMillis());
		return rm;
	}

}
