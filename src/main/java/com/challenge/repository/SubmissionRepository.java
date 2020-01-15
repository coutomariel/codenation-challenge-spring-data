package com.challenge.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, SubmissionId>{

	@Query("select s from Submission s "
			+ "join Challenge c on c.id = s.id.challenge "
			+ "join Acceleration a on a.challenge = c.id "
				+ "where c.id = :challengeId and a.id = :accelerationId " )
	public List<Submission> findByChallengeIdAndAccelerationId(@Param("challengeId") Long challengeId, 
			@Param("accelerationId") Long accelerationId);

	@Query("select max(s.score) from Submission s "
			+ "join Challenge c on c.id = s.id.challenge "
				+ "where c.id = :challengeId")
	public BigDecimal findHigherScoreByChallengeId(@Param("challengeId") Long challengeId);

}
