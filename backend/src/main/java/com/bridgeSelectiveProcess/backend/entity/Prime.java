package com.bridgeSelectiveProcess.backend.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bridgeSelectiveProcess.backend.utils.PrimeUtils;

@Entity
public class Prime {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@Column(nullable = false)
    private Integer lowerRange;
	
	@Column(nullable = false)
    private Integer topRange;
	
	@Column(nullable = false)
	@ElementCollection(targetClass=Integer.class)
    private List<Integer> resultSet = new ArrayList();
	
	public Prime() {}

	public Prime(int lowerRange, int topRange, List resultSet) {
		super();
		this.lowerRange = lowerRange;
		this.topRange = topRange;
		this.resultSet = resultSet;
	}
	
	public Prime(int lowerRange, int topRange) {
		super();
		this.lowerRange = lowerRange;
		this.topRange = topRange;
		this.resultSet = PrimeUtils.getPrimesInRange(lowerRange, topRange);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getLowerRange() {
		return lowerRange;
	}

	public void setLowerRange(int lowerRange) {
		this.lowerRange = lowerRange;
	}

	public int getTopRange() {
		return topRange;
	}

	public void setTopRange(int topRange) {
		this.topRange = topRange;
	}

	public List getResultSet() {
		return resultSet;
	}

	public void setResultSet(List resultSet) {
		this.resultSet = resultSet;
	}
	
	public String toString() {
		return "Prime = { lowerRange: "+this.lowerRange+" , topRange: "+this.topRange+", resultSet: "+this.resultSet+" }";
	}
	
	
	
	
	
}
