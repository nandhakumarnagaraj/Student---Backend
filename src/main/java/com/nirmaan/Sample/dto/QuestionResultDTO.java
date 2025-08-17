package com.nirmaan.Sample.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResultDTO {
	private String questionText;
	private Integer selectedOptionIndex;
	private Integer correctOptionIndex;
	private Boolean isCorrect;
	private String selectedOptionText;
	private String correctOptionText;
	private Integer marks;
}