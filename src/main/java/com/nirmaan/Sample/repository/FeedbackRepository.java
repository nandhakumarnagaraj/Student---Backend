package com.nirmaan.Sample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nirmaan.Sample.entity.Feedback;
import com.nirmaan.Sample.entity.User;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
	List<Feedback> findByStudent(User student);

	List<Feedback> findByStatus(Feedback.FeedbackStatus status);

	List<Feedback> findByCategory(Feedback.FeedbackCategory category);

	List<Feedback> findByOrderByCreatedAtDesc();
}
