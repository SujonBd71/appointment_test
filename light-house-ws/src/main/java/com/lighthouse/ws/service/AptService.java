package com.lighthouse.ws.service;

import com.lighthouse.ws.ui.model.request.AppointmentDetailsRequestModel;
import com.lighthouse.ws.ui.model.response.AppointmentRest;

public interface AptService {

	public AppointmentRest createAppointment(AppointmentDetailsRequestModel request) throws Exception;

	public AppointmentRest getAppointmentByID(int id) throws Exception;

}
