package com.lighthouse.ws;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.lighthouse.ws.ui.model.request.AppointmentDetailsRequestModel;
import com.lighthouse.ws.ui.model.response.AppointmentRest;
import com.lighthouse.ws.ui.model.response.ErrorMessages;
import com.lighthouse.ws.Dentist;

@Repository
public class AppointmentRepo {
	ArrayList<AppointmentDetailsRequestModel> Appointments = new ArrayList<AppointmentDetailsRequestModel>();
	ArrayList<Dentist> dentists = new ArrayList<Dentist>();

	public String testCall() {
		return "test";
	}

	int findDentistIndex(long id) {
		for (int i = 0; i < dentists.size(); i++) {
			if (dentists.get(i).getId() == id) {
				return i;
			}
		}

		return -1;
	}

	public boolean isDentistAvailable(long dentistId, long start) {
		int dentistIndex = findDentistIndex(dentistId);
		if (dentistIndex == -1) {
			return true;
		}

		ArrayList<Long> dentistAppointments = dentists.get(dentistIndex).getAppointmets();

		for (int i = 0; i < dentistAppointments.size(); i++) {
			long aptId = dentistAppointments.get(i);
			AppointmentDetailsRequestModel aptDetails = Appointments.get((int) aptId - 1);

			if (aptDetails.getStartTime() == start) {
				return false;
			}
		}

		return true;

//		return false;
	}

	public long addAppointment(AppointmentDetailsRequestModel request) {
		Appointments.add(request);
		updateDentistTable(request);
		return Appointments.size();
	}

	private void updateDentistTable(AppointmentDetailsRequestModel request) {

		int dentistIndex = findDentistIndex(request.getDentist_id());
		if (dentistIndex == -1) {
			Dentist dentist = new Dentist(request.getDentist_id());
			dentists.add(dentist);
			dentistIndex = dentists.size() - 1;
		}

		dentists.get(dentistIndex).addAppointment((long) Appointments.size());
	}

	public AppointmentRest getAptMyId(int id) throws Exception {

		if (id < 1 || id > Appointments.size())
			throw new Exception(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());

		id--;
		AppointmentRest response = new AppointmentRest(id + 1, Appointments.get(id).getStartTime(),
				Appointments.get(id).getEndTime(), Appointments.get(id).getDentist_id(),
				Appointments.get(id).getPatient_id());

		return response;
	}

}
