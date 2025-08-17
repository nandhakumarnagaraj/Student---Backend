package com.nirmaan.Sample.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizResultDTO {
	private Long attemptId;
	private String quizTitle;
	private Integer scoreObtained;
	private Integer totalMarks;
	private Integer correctAnswers;
	private Integer totalQuestions;
	private Double percentage;
	private LocalDateTime submittedAt;
	private List<QuestionResultDTO> questionResults;
}
