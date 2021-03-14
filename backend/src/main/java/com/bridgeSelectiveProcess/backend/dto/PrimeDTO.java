package com.bridgeSelectiveProcess.backend.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bridgeSelectiveProcess.backend.entity.Prime;
import com.bridgeSelectiveProcess.backend.utils.PrimeUtils;

public class PrimeDTO {
	
    private String lowerRange;
    private String topRange;
	
	public PrimeDTO() {}

	public PrimeDTO(String lowerRange, String topRange) {
		super();
		this.lowerRange = lowerRange;
		this.topRange = topRange;
	}


	public String getLowerRange() {
		return lowerRange;
	}

	public void setLowerRange(String lowerRange) {
		this.lowerRange = lowerRange;
	}

	public String getTopRange() {
		return topRange;
	}

	public void setTopRange(String topRange) {
		this.topRange = topRange;
	}
	
	public Prime toPrime() {
		return new Prime(Integer.parseInt(this.lowerRange), Integer.parseInt(this.topRange));
	}
	
	public String toString() {
		return "PrimeDTO = { lowerRange: "+this.lowerRange+" , topRange: "+this.topRange+" }";
	}
	
	
	
	
	
}
