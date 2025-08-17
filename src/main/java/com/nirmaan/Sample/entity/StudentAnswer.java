package com.nirmaan.Sample.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student_answers")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentAnswer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "quiz_attempt_id", nullable = false)
	private QuizAttempt quizAttempt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "question_id", nullable = false)
	private Question question;

	private Integer selectedOptionIndex;

	@Column(nullable = false)
	private Boolean isCorrect = false;

	@Column(nullable = false)
	private LocalDateTime answeredAt = LocalDateTime.now();
}
