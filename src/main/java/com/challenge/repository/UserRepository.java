package com.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.challenge.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public List<User> findByFullNameContaining(String name);
	
	@Query("select u from User u "
			+ "join Candidate c on u.id = c.id.user "
			+ "join Acceleration a on a.id = c.id.acceleration "
			+ "where a.name = :name")
	public List<User> findByAccelerationName(@Param("name") String name);
	
	@Query("select u from User u "
			+ "join Candidate c on u.id = c.id.user "
			+ "join Company cp on cp.id = c.id.company "
			+ "where cp.id = :companyId")
	public List<User> findByCompanyId(@Param("companyId")Long companyId);
	
}
