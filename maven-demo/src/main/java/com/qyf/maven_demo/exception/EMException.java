package com.qyf.maven_demo.exception;

/**
 * 自定义异常：错误信息提示
 *
 */
public class EMException extends Exception{

	private static final long serialVersionUID = 1L;

	public EMException(String msg) {
		super(msg);
	}
}