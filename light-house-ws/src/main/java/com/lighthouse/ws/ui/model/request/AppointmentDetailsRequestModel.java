package com.lighthouse.ws.ui.model.request;

public class AppointmentDetailsRequestModel {

	public AppointmentDetailsRequestModel(long startTime, long endTime, long dentist_id, long patient_id) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.dentist_id = dentist_id;
		this.patient_id = patient_id;
	}

	private long startTime;
	private long endTime;
	private long dentist_id;
	private long patient_id;

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public long getDentist_id() {
		return dentist_id;
	}

	public void setDentist_id(long dentist_id) {
		this.dentist_id = dentist_id;
	}

	public long getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(long patient_id) {
		this.patient_id = patient_id;
	}

}
