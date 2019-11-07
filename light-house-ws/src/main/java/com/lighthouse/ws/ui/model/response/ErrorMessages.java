package com.lighthouse.ws.ui.model.response;

public enum ErrorMessages {
	NO_RECORD_FOUND("record with provide id doesn't exists"),
	SCHEDULE_NOT_AVAILABLE("provided time slot is not available"), TIME_INVALID("given time is not valid"),
	TIME_INVALID_PAST("provided time is in the past"),
	TIME_INVALID_TOO_SHORT("provided time is too short. Need atleast 30 minutes");

	private String errorMessage;

	private ErrorMessages(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
