package org.booking.meeting.advice;

import java.time.LocalDateTime;

import org.booking.meeting.model.ErrorResponse;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BookingControllerAdvice {

	@ExceptionHandler(value = NotFoundException.class)
	public ResponseEntity<ErrorResponse> handleGenericNotFoundExceptionn(NotFoundException e) {
		ErrorResponse response = new ErrorResponse("NOT_FOUND_ERROR");
		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<ErrorResponse> handleDataResultException(EmptyResultDataAccessException e) {
		ErrorResponse response = new ErrorResponse("DATA_ERROR: PLEASE PROVIDE VALID INPUT");
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponse> handleGenericRuntimeExceptionn(RuntimeException e) {
		ErrorResponse response = new ErrorResponse("INTERNAL_SERVER_ERROR");
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
