package com.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Challenge;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {

	
	@Query("select c from Challenge c "
			+ "join Acceleration a on a.challenge = c.id "
			+ "join Submission s on s.id.challenge = c.id "
			+ "join User u on u.id = s.id.user "
				+ "where a.id = :accelerationId and u.id = :userId")
	public List<Challenge> findByAccelerationIdAndUserId(@Param("accelerationId") Long accelerationId, 
									@Param("userId") Long userId);

}
