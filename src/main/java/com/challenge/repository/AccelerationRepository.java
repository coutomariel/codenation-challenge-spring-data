package com.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Acceleration;

@Repository
public interface AccelerationRepository extends JpaRepository<Acceleration, Long>{

	@Query("select a from Acceleration a "
			+ "join Candidate cd on cd.id.acceleration = a.id "
			+ "join Company cp on cp.id = cd.id.company "
			+ "where cp.id = :companyId ")
	public List<Acceleration> findByCompanyId(@Param("companyId") Long companyId);

}
