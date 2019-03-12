package com.javaconvergence.exception;

import java.io.IOException;

/**
 * Exception handling precedence is, Throwable > Exception > RuntimeException
 * and Throwable > Error
 * 
 * Both Exception & Error are derived from Throwable. Thus Throwable has higher
 * precedence than others.
 */
public class ExceptionErrorOrderDemo {

	private static void execute(String type) {
		try {
			switch (type) {
			case "RuntimeException":
				throw new ArithmeticException();
			case "Exception":
				throw new IOException();
			case "Error":
				throw new StackOverflowError();
			default:
				throw new Exception();
			}
		} catch (RuntimeException ex) { /* capture only Run time and its derived exceptions */
			System.out.println("RuntimeException : " + ex.getMessage());
		} catch (Exception ex) {/* capture all checked & unchecked exceptions */
			System.out.println("Exception : " + ex.getMessage());
		} catch (Error err) {/* capture only error and its derived types */
			System.out.println("Error : " + err.getMessage());
		} catch (Throwable t) { /* capture anything */
			System.out.println("Throwable : " + t.getMessage());
		}
	}

	public static void main(String[] args) {

		execute("RuntimeException");
		execute("Exception");
		execute("Error");

	}

}
