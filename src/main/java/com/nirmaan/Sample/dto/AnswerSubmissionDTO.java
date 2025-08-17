package com.nirmaan.Sample.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerSubmissionDTO {
	private Long questionId;
	private Integer selectedOptionIndex;
}
