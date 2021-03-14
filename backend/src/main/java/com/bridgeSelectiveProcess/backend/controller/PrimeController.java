package com.bridgeSelectiveProcess.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bridgeSelectiveProcess.backend.repository.PrimeRepository;
import com.bridgeSelectiveProcess.backend.dto.PrimeDTO;
import com.bridgeSelectiveProcess.backend.entity.Prime;

@RestController
public class PrimeController {
	
	@Autowired
	PrimeRepository repository;
	
	@CrossOrigin
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Prime> getAll(){
		//System.out.println("Returning all values");
		return repository.findAll();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Prime> getById(@PathVariable(value="id") Long id) {
		Optional<Prime> p = repository.findById(id);
		//System.out.println("Returning value with id: "+id);
		
		if(p.isPresent())
            return new ResponseEntity<Prime>(p.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	@CrossOrigin
	@RequestMapping(value = "/{low}/{top}", method = RequestMethod.POST)
	public ResponseEntity<Prime> addPrime(@PathVariable(value="low") Integer low, @PathVariable(value="top") Integer top) {
		Optional<Prime> p = repository.getPrimeByRanges(low, top);
		Prime prime;
		
		if(p.isPresent())
            return new ResponseEntity<Prime>(p.get(), HttpStatus.OK);
        else
        	prime = new Prime(low.intValue(), top.intValue());
			return new ResponseEntity<Prime>(repository.save(prime), HttpStatus.OK);
		
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Prime> addPrimeBody(@RequestBody PrimeDTO primedto) {
		Prime primepassed = primedto.toPrime();
		
		Optional<Prime> p = repository.getPrimeByRanges(primepassed.getLowerRange(), primepassed.getTopRange());
		Prime prime;
		
		if(p.isPresent())
            return new ResponseEntity<Prime>(p.get(), HttpStatus.OK);
        else
        	prime = new Prime(primepassed.getLowerRange(), primepassed.getTopRange());
			return new ResponseEntity<Prime>(repository.save(prime), HttpStatus.OK);
		
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "/{low}/{top}", method = RequestMethod.GET)
	public ResponseEntity<Prime> getPrimeByRange(@PathVariable(value="low") Integer low, @PathVariable(value="top") Integer top) {
		Optional<Prime> p = repository.getPrimeByRanges(low, top);
		
		if(p.isPresent())
            return new ResponseEntity<Prime>(p.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable(value = "id") long id) {
		
		Optional<Prime> p = repository.findById(id);
        if(p.isPresent()){
            repository.delete(p.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
