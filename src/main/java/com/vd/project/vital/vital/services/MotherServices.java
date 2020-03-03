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
public interface MotherServices {

	 List<Mother> getAllMothers() ;

		
	//to get a single mother
		
		String getmother(Long id) ;

		
	//to add a mother along with her children
		 void addMother(Mother mother);

		
	//to get male children along with her mother
		 Optional<Mother> getMotherMaleChildren(Long id, String Gender);

		
	//to get total children
		 int gettotal(long id);
	
}
