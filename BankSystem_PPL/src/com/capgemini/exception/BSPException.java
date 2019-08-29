package com.capgemini.exception;

public class BSPException extends Exception{

	public BSPException() {
		super();
	}

	public BSPException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public BSPException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public BSPException(String arg0) {
		super(arg0);
	}

	public BSPException(Throwable arg0) {
		super(arg0);
	}

}
