package main.java.com.springrest.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import main.utilities.CustomerErrorResponse;
import main.utilities.CustomerNotFoundException;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	// Add an exception Handler for CustomerNotFound Exception	
	// Incase of out of bounds value which is not available in the list like 0 or above
	
	  @ExceptionHandler 
	  public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc){
	  
		// create CustomerErrorResponse
			
			CustomerErrorResponse error = new CustomerErrorResponse(
												HttpStatus.NOT_FOUND.value(),
												exc.getMessage(),
												System.currentTimeMillis());			
			// return ResponseEntity			
			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	  
	  }
	  
	// Add another exception handler ... to catch any exception (catch all) 

		@ExceptionHandler
		public ResponseEntity<CustomerErrorResponse> handleException(Exception exc) {
			
			// create CustomerErrorResponse
			
			CustomerErrorResponse error = new CustomerErrorResponse(
												HttpStatus.BAD_REQUEST.value(),
												exc.getMessage(),
												System.currentTimeMillis());
			
			// return ResponseEntity
			
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
	  
	  
}

