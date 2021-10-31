package com.codingdojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.models.Dojo;
import com.codingdojo.models.Ninja;
import com.codingdojo.repositories.DojoRepository;
import com.codingdojo.repositories.NinjaRepository;


@Service
public class DojoNinServer {

	private final DojoRepository dojoRepository;
	private final NinjaRepository ninjaRepository;
	
	public DojoNinServer( DojoRepository dojoRepository, NinjaRepository ninjaRepository ) {
		this.dojoRepository = dojoRepository;
		this.ninjaRepository = ninjaRepository;
	}
	
	//Retrieve all dojos
	public List<Dojo> getAllDojos() {
		return dojoRepository.findAll();
	}
	
	//Retrieve Dojo by Id
	public Dojo getDojoById( Long id ) {
		Optional<Dojo> optionalDojo = dojoRepository.findById( id );
		if( optionalDojo.isPresent() ) {
			return optionalDojo.get();
		}
		else {
			return null;
		}
	}
		
	
	//Create Dojo
	public Dojo createDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	
	//Retrieve all Ninjas
	public List<Ninja> allNinjas() {
		return ninjaRepository.findAll();
	}
	
	//Create Ninja
	public Ninja createNinja( Ninja ninja ) {
		return ninjaRepository.save( ninja );
	}
	
	
}
