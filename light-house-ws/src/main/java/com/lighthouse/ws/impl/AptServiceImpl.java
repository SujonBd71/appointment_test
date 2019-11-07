package com.lighthouse.ws.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lighthouse.ws.AppointmentRepo;
import com.lighthouse.ws.service.AptService;
import com.lighthouse.ws.ui.model.request.AppointmentDetailsRequestModel;
import com.lighthouse.ws.ui.model.response.AppointmentRest;
import com.lighthouse.ws.ui.model.response.ErrorMessages;

@Service
public class AptServiceImpl implements AptService {

	@Autowired
	AppointmentRepo aptRepository;

	@Override
	public AppointmentRest createAppointment(AppointmentDetailsRequestModel request) throws Exception {

		AppointmentRest response = new AppointmentRest(-1, request.getStartTime(), request.getEndTime(),
				request.getDentist_id(), request.getPatient_id());

		if (!isValidSchedule(request.getStartTime(), request.getEndTime())) {
			throw new Exception(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
			// return response;
		}

		if (!aptRepository.isDentistAvailable(request.getDentist_id(), request.getStartTime())) {

			throw new Exception(ErrorMessages.SCHEDULE_NOT_AVAILABLE.getErrorMessage());
			// return response;
		}

		long id = aptRepository.addAppointment(request);
		response.setId(id);

		return response;
	}

	private boolean isValidSchedule(long start, long end) throws Exception {
		long currTime = System.currentTimeMillis();

		// can't be past
		if (start < currTime || end < currTime) {

			throw new Exception(ErrorMessages.TIME_INVALID_PAST.getErrorMessage());
			// return false;
		}

		if (end < start) {
			throw new Exception(ErrorMessages.TIME_INVALID.getErrorMessage());
		}

		if ((end - start) < (30 * 60 * 1000)) {
			throw new Exception(ErrorMessages.TIME_INVALID_TOO_SHORT.getErrorMessage());
			// return false;
		}

		return true;
	}

	public AppointmentRest getAppointmentByID(int id) throws Exception {
		return aptRepository.getAptMyId(id);
	}
}
