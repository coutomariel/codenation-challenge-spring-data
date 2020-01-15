package com.challenge.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, CandidateId>{
	
	@Query("select c from Candidate c "
			+ "where c.id.user = :userId "
			+ "and c.id.company = :companyId "
			+ "and c.id.acceleration = :accelerationId ")
	public Optional<Candidate> findByCandidateId(@Param("userId") Long userId,
					@Param("companyId") Long companyId,	@Param("accelerationId")Long accelerationId);

	@Query("select c from Candidate c "
			+ "join Company cp on cp.id = c.id.company "
			+ "where cp.id = :companyId ")
	public List<Candidate> findByCompanyId(@Param("companyId") Long companyId);

	@Query("select c from Candidate c "
			+ "join Acceleration a on a.id = c.id.acceleration "
			+ "where a.id = :accelerationId ")
	public List<Candidate> findByAccelertionId(@Param("accelerationId")Long accelerationId);
	
}

	
