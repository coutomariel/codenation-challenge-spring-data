package com.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{

//	@Query("select cp from Company cp "
//			+ "join Candidate cd on cd.id.company = cp.id "
//			+ "join Acceleration a on cd.id.acceleration = a.id "
//				+ "where a.id = :accelerationId")
//	public List<Company> findByAccelerationId(@Param("accelerationId") Long accelerationId);
	
	List<Company> findDistinctByCandidatesIdAccelerationId(Long accelerationId);

	@Query("select cp from Company cp "
			+ "join Candidate cd on cd.id.company = cp.id "
			+ "join User u on u.id = cd.id.user "
				+ "where u.id = :userId")
	public List<Company> findByUserId(@Param("userId") Long userId);

}
