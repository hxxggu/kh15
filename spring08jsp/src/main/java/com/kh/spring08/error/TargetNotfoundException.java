package com.kh.spring08.error;

public class TargetNotfoundException extends RuntimeException {

	public TargetNotfoundException() {
		super();
	}

	public TargetNotfoundException(String message) {
		super(message);
	}
}