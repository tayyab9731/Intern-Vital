package com.vd.project.vital.vital.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vd.project.vital.vital.model.Mother;
import com.vd.project.vital.vital.repositories.motherRepositories;
import com.vd.projject.vital.Exceptions.MotherNotFoundException;

@Service
public class motherServices {
	@Autowired
	private motherRepositories repo;

	
// to get all the mothers
	
	public List<Mother> getAllMothers() {
	
		List<Mother> mothers = new ArrayList<>();
		try {
		repo.findAll().forEach(mothers::add);
		}catch(Exception e)
		{
			System.out.println("sorry nothing found");
		}return mothers;
	}

	
//to get a single mother
	@Test
	public Mother getmother(Long id) {
		return repo.findById(id).orElseThrow(()->new MotherNotFoundException(id));
	}

	
//to add a mother along with her children
	public void addMother(Mother mother) {
		// TODO Auto-generated method stub
		try {
			repo.save(mother);
		} catch (Exception ex) {
			String msg = ex.getMessage();
		}
		if(mother.getBasicinfo()==null)
		{System.out.println("dasdsds");}
	}

	
//to get male children along with her mother
	public Optional<Mother> getMotherMaleChildren(Long id, String Gender) {
		
			return repo.findByIdChildren(id, Gender);
		
	}

	
//to get total children
	public int gettotal(long id) {
		// TODO Auto-generated method stub
		return repo.totalchildren(id);
	}
}
