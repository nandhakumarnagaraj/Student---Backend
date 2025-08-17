package com.nirmaan.Sample.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "quiz_attempts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizAttempt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id", nullable = false)
	private User student;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "quiz_id", nullable = false)
	private Quiz quiz;

	@Column(nullable = false)
	private LocalDateTime startedAt;

	private LocalDateTime submittedAt;

	private Integer scoreObtained;

	private Integer totalQuestions;

	private Integer correctAnswers;

	@Column(nullable = false)
	private Boolean isCompleted = false;

	@OneToMany(mappedBy = "quizAttempt", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<StudentAnswer> answers;
}
