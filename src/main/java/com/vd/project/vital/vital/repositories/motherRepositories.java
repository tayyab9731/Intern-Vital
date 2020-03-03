package com.vd.project.vital.vital.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vd.project.vital.vital.model.Mother;
@Repository
public interface  motherRepositories extends CrudRepository<Mother,Long>{


@Query(nativeQuery=true,value="SELECT * " + 
		"FROM   mother m, jsonb_array_elements(m.basicinfo->'Children') ch " + 
		"WHERE  ch->>'Gender' = ?2  and m.id=?1" )
Optional<Mother> findByIdChildren(Long id,String gender);

@Query(nativeQuery=true,value="SELECT count(*) " + 
		"FROM   mother m, jsonb_array_elements(m.basicinfo->'Children') ch " + 
		"WHERE  m.id=?1" )
int totalchildren(long id);


}
