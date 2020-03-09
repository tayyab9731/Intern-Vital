package com.vd.project.vital.vital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vd.project.vital.vital.model.Mother;
import com.vd.project.vital.vital.services.MotherServices;

@RestController
public class mothercontroller {

	@Autowired
	private MotherServices service;

	@RequestMapping("/motherChildren/{id}/{Gender}")
	public ResponseEntity<String> getMotherChildren(@PathVariable("id") Long id,
			@PathVariable("Gender") String Gender) {
		boolean temp = service.getMotherChildren(id, Gender).isPresent();
		try {
			if (temp == true) {
				return new ResponseEntity<String>(
						"Her children are " + "" + service.getMotherChildren(id, Gender).get().print(), HttpStatus.OK);
			} else
				return new ResponseEntity<String>("She doesn't have children ", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Invalid", HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping("/mothers")
	public List<Mother> getAll() {
		return service.getAllMothers();
	}

	@RequestMapping("/mother/{id}")
	@ResponseBody
	public ResponseEntity<String> getmother(@PathVariable("id") long id) {
		try {
			return new ResponseEntity<String>("" + service.getmother(id).get().print(), HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<String>("The mother with the given id is not found", HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping("/mother/{id}/children")
	@ResponseBody
	public ResponseEntity<String> gettotalchildren(@PathVariable("id") long id) {
		try {
			if (service.gettotal(id) != 0)
				return new ResponseEntity<String>(
						"The mother with the given id have " + " " + service.gettotal(id) + " children",
						HttpStatus.FOUND);
			else
				return new ResponseEntity<String>("She doesn't have children ", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Invalid", HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addmother")
	public ResponseEntity<String> addmother(@RequestBody Mother mother) {
		try {
			if (service.addMother(mother) == true)
				return new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
			else
				return new ResponseEntity<String>("Sorry Can't insert please provide all the information",
						HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (Exception e) {
			return new ResponseEntity<String>("Invalid", HttpStatus.NOT_FOUND);
		}
	}
}
