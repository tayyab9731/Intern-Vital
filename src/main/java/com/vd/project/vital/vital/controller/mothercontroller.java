package com.vd.project.vital.vital.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vd.project.vital.vital.model.Mother;
import com.vd.project.vital.vital.services.MotherServices;


@RestController
public class mothercontroller {
	
	@Autowired
private MotherServices service;
	
	
	
@RequestMapping("/mothersChildren/{id}/{Gender}")
public Optional<Mother> getMotherMaleChildren(@PathVariable("id") Long id,@PathVariable("Gender") String Gender)
{
	return service.getMotherMaleChildren(id,Gender);
}




@RequestMapping("/mothers")
public List<Mother> getAll()
{return service.getAllMothers();
}	




@RequestMapping("/mother/{id}")
@ResponseBody
public Mother getmother(@PathVariable("id") long id){

		
	return service.getmother(id);
}



@RequestMapping("/mothers/{id}/children")
@ResponseBody
public int gettotalchildren(@PathVariable("id") long id)
{return service.gettotal(id);
	}



@RequestMapping(method=RequestMethod.POST , value="/mother")
public void addMother(@RequestBody Mother mother)
	{
		service.addMother(mother);
	}
}
