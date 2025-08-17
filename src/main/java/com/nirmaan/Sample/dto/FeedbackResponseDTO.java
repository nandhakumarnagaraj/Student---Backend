package com.nirmaan.Sample.dto;

import java.time.LocalDateTime;

import com.nirmaan.Sample.entity.Feedback;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackResponseDTO {
	private Long id;
	private String studentName;
	private String subject;
	private String message;
	private Feedback.FeedbackCategory category;
	private Integer rating;
	private Feedback.FeedbackStatus status;
	private String adminResponse;
	private LocalDateTime createdAt;
	private LocalDateTime respondedAt;
}
