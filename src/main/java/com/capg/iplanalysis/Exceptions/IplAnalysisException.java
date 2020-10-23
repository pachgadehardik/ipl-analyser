package com.capg.iplanalysis.Exceptions;


public class IplAnalysisException extends Exception{


	private static final long serialVersionUID = 7645067617351895645L;

	public enum IplExceptionType{
		FILE_NOT_FOUND_TYPE, INCORRECT_TYPE, DELIMITER_OR_HEADER_TYPE, OTHER_TYPE
	}
	
	public IplExceptionType type;
	private String msg;
	
	  public IplAnalysisException() {
	    }

	public IplAnalysisException(IplExceptionType type, String msg) {
		super(msg);
		this.type = type;
	}
	
	
}
