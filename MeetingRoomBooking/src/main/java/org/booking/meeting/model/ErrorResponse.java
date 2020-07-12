package org.booking.meeting.model;

import java.time.LocalDateTime;

public class ErrorResponse {
	private int status;
	private String errorMsg;
	private LocalDateTime timeStamp;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public ErrorResponse(String errorMsg) {
		super();
		this.errorMsg = errorMsg;
	}
}
