package com.lighthouse.ws;

import java.util.ArrayList;

public class Dentist {
	public Dentist(long id) {
		this.id = id;
	}

	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	private ArrayList<Long> appointments = new ArrayList<Long>();

	public ArrayList<Long> getAppointmets() {
		return appointments;
	}

	void addAppointment(Long id) {
		appointments.add(new Long(id));
	}

}
