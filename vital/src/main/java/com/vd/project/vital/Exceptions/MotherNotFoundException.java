package com.vd.project.vital.Exceptions;

public class MotherNotFoundException extends RuntimeException{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MotherNotFoundException(Long id) {
	        super("Mother id not found :" + id);
	    }
}
