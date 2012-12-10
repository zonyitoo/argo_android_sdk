package edu.sysubbs.argoandroid.util;

public class ErrorException extends Exception {
	public String msg = null;
	public String errorCode = null;
	
	public ErrorException(String msg, String errorCode) {
		this.msg = msg;
		this.errorCode = errorCode;
	}
}
