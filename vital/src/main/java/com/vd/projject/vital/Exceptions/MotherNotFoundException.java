package com.vd.projject.vital.Exceptions;

public class MotherNotFoundException extends RuntimeException{
	  public MotherNotFoundException(Long id) {
	        super("Mother id not found : " + id);
	    }
}
