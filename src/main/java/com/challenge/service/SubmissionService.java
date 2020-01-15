package com.challenge.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Submission;
import com.challenge.repository.SubmissionRepository;
import com.challenge.service.interfaces.SubmissionServiceInterface;

@Service
public class SubmissionService implements SubmissionServiceInterface{

	@Autowired
	private SubmissionRepository submissionRepository;

	@Override
	public Submission save(Submission object) {
		return submissionRepository.save(object);
	}
	
	@Override
	public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
		return submissionRepository.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
	}

	@Override
	public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
		
		if(submissionRepository.findHigherScoreByChallengeId(challengeId)==null) {
			return new BigDecimal(0);
		}
		return submissionRepository.findHigherScoreByChallengeId(challengeId);
	}
	
	
}
