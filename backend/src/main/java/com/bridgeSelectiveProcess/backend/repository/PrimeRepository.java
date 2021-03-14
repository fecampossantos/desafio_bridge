package com.bridgeSelectiveProcess.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bridgeSelectiveProcess.backend.entity.Prime;

@Repository
public interface PrimeRepository extends JpaRepository<Prime, Long>{ 
	
	/**
	 * Method that returns a Prime object if it already exists within the specified range, and null if it doesnt
	 * @param lowerRange
	 * @Param topRange
	 * @return List of Samples
	 */
	@Query("SELECT p FROM Prime p WHERE p.lowerRange = :lowerRange AND p.topRange = :topRange")
	Optional<Prime> getPrimeByRanges(@Param("lowerRange") Integer lowerRange, @Param("topRange") Integer topRange);

}
