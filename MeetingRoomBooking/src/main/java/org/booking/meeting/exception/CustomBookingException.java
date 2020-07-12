package org.booking.meeting.exception;

import java.time.LocalDateTime;

public class CustomBookingException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3108813713812653937L;

	private LocalDateTime timeStamp;
	private int status;

	public CustomBookingException(String msg) {
		super(msg);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

}
