package com.codingdojo.repositories;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.codingdojo.models.Ninja;

public interface NinjaRepository extends Repository<Ninja, Long>{
	public List<Ninja> findAll();
	//public Ninja findTopByOrderByNumberDesc();
	
	Ninja save( Ninja ninja );
}
