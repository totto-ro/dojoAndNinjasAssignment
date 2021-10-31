package com.codingdojo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.models.Dojo;
import com.codingdojo.models.Ninja;
import com.codingdojo.services.DojoNinServer;

@Controller
public class DojoController {

	private final DojoNinServer dojoNinServer;
	
	public DojoController( DojoNinServer dojoNinServer ) {
		this.dojoNinServer = dojoNinServer;  
	}
	
	
	//Render form to create new dojo
	@RequestMapping( value = "/dojos/new", method = RequestMethod.GET )
	public String newDojo( @ModelAttribute("dojo") Dojo dojo ) {
		return "newDojo.jsp";
	}
	
	//Create new dojo
	@RequestMapping( value = "/dojos/new", method = RequestMethod.POST )
	public String createDojo( @ModelAttribute("dojo") Dojo dojo, BindingResult result ) {
		if(result.hasErrors())
			return "/dojos/new.jsp";
		this.dojoNinServer.createDojo( dojo );
		return "redirect:/";
	}
	
	//Retrieving all Info
	@RequestMapping( value = "/", method = RequestMethod.GET )
	public String AllInfo( @ModelAttribute( "dojo" ) Dojo dojo, Model model ) {
		List<Dojo> dojoList = dojoNinServer.getAllDojos();
		
		model.addAttribute( "dojoList", dojoList );
		return "index.jsp";
	}
	
	//Render form to create ninja
	@RequestMapping( value="/ninjas/new", method=RequestMethod.GET )
	public String NewNinja( @ModelAttribute( "ninja" ) Ninja ninja, Model model ) {
		model.addAttribute("dojo", dojoNinServer.getAllDojos() );
		return "newNinja.jsp";
	}
	
	//Create new ninja
	@RequestMapping( value = "/ninjas/new", method=RequestMethod.POST )
	public String createNinja(@Valid @ModelAttribute( "ninja" ) Ninja ninja, Model model, BindingResult result) {
		
		if( result.hasErrors() ) {
			model.addAttribute("dojo", dojoNinServer.getAllDojos() );
			return "newNinja.jsp";
		}	
		dojoNinServer.createNinja( ninja );
		return "redirect:/";
	}
	
	//Get Dojo by Id
	@RequestMapping( value= "/dojos/{id}", method=RequestMethod.GET )
	public String showDojo(@PathVariable("id") Long id, Model model ) {
		
		
		model.addAttribute("dojoInfo", dojoNinServer.getDojoById( id ) );
		return "showDojo.jsp";
	}
	
}
