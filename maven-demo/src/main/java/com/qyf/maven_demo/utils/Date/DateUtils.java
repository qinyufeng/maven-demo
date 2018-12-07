package com.qyf.maven_demo.utils.Date;

import java.text.SimpleDateFormat;

public final class DateUtils {
	/** 日期格式 **/
	public interface DATE_MODEl {
		String HHMMSS = "HHmmss";
		String HH_MM_SS = "HH:mm:ss";
		String YYYYMMDD = "yyyyMMdd";
		String YYYY_MM_DD = "yyyy-MM-dd";
		String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
		String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
		String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
		String YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
		String YY="yy";
		String YYMMDD = "yyMMdd";
		String YY_MM_DD = "yy-MM-dd";
	}
	public static void main(String[] args) {
		//String test=getDateStr(new Date(),"yy");
		//System.out.println(test);
	}
	public static final String getDateStr(Object date, String pattern) {
		if (date == null) {
			return null;
		}
		if (pattern == null) {
			return new SimpleDateFormat("yyyyMMdd").format(date);
		}else if(pattern.equals(DATE_MODEl.YY)) {
			return new SimpleDateFormat(pattern).format(date);
		}else if(pattern.equals(DATE_MODEl.YY_MM_DD)) {
			return new SimpleDateFormat(pattern).format(date);
		}else if(pattern.equals(DATE_MODEl.YYMMDD)) {
			return new SimpleDateFormat(pattern).format(date);
		}else if(pattern.equals(DATE_MODEl.YYYY_MM_DD)) {
			return new SimpleDateFormat(pattern).format(date);
		}else if(pattern.equals(DATE_MODEl.YYYY_MM_DD_HH_MM_SS)) {
			return new SimpleDateFormat(pattern).format(date);
		}else if(pattern.equals(DATE_MODEl.YYYY_MM_DD_HH_MM_SS_SSS)) {
			return new SimpleDateFormat(pattern).format(date);
		}else if(pattern.equals(DATE_MODEl.YYYYMMDD)) {
			return new SimpleDateFormat(pattern).format(date);
		}else if(pattern.equals(DATE_MODEl.YYYYMMDDHHMMSS)) {
			return new SimpleDateFormat(pattern).format(date);
		}else if(pattern.equals(DATE_MODEl.YYYYMMDDHHMMSSSSS)) {
			return new SimpleDateFormat(pattern).format(date);
		}else if(pattern.equals(DATE_MODEl.HHMMSS)) {
			return new SimpleDateFormat(pattern).format(date);
		}else if(pattern.equals(DATE_MODEl.HH_MM_SS)) {
			return new SimpleDateFormat(pattern).format(date);
		}
		return new SimpleDateFormat(pattern).format(date);
	}
}
