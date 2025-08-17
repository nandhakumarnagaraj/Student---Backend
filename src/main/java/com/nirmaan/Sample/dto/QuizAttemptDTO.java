package com.nirmaan.Sample.dto;

import java.time.LocalDateTime;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizAttemptDTO {
	private Long id;
	private Long quizId;
	private String quizTitle;
	private LocalDateTime startedAt;
	private LocalDateTime submittedAt;
	private Integer scoreObtained;
	private Integer totalQuestions;
	private Integer correctAnswers;
	private Boolean isCompleted;
	private String studentName;
}