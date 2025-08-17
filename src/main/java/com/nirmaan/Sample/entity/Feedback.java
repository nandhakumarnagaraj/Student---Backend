package com.nirmaan.Sample.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "feedback")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id", nullable = false)
	private User student;

	@Column(nullable = false)
	private String subject;

	@Column(columnDefinition = "TEXT", nullable = false)
	private String message;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private FeedbackCategory category;

	@Column(nullable = false)
	private Integer rating; // 1-5 scale

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private FeedbackStatus status = FeedbackStatus.PENDING;

	private String adminResponse;

	@Column(nullable = false)
	private LocalDateTime createdAt = LocalDateTime.now();

	private LocalDateTime respondedAt;

	public enum FeedbackCategory {
		TEACHING, INFRASTRUCTURE, ADMINISTRATION, TECHNICAL, OTHER
	}

	public enum FeedbackStatus {
		PENDING, REVIEWED, RESOLVED
	}
}
