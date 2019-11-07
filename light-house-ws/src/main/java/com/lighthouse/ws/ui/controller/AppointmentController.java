package com.lighthouse.ws.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lighthouse.ws.service.AptService;
import com.lighthouse.ws.ui.model.request.AppointmentDetailsRequestModel;
import com.lighthouse.ws.ui.model.response.AppointmentRest;

@RestController
@RequestMapping("")
public class AppointmentController {

	@Autowired
	AptService aptService;

	@GetMapping(path = "/{id}")
	public AppointmentRest getAppointment(@PathVariable long id) throws Exception {
		return aptService.getAppointmentByID((int) id);
	}

	@PostMapping
	public AppointmentRest createAppoinment(@RequestBody AppointmentDetailsRequestModel request) throws Exception {
		return aptService.createAppointment(request);
	}

}
