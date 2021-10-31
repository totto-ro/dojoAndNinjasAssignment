package com.codingdojo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.codingdojo.models.Dojo;


public interface DojoRepository extends Repository<Dojo, Long>{
	List<Dojo> findAll();
	
	//@Query(value="SELECT dojos. * FROM dojos LEFT OUTER JOIN ninjas ON dojos.id = ninjas.dojo_id WHERE ninjas.id IS NULL;", nativeQuery=true)
	//List<Dojo> findByNoNinja();
	
	//List<Dojo> findByNinjaIdIsNull();
	
	Dojo save( Dojo person );
	
	Optional<Dojo> findById( Long id );
}
