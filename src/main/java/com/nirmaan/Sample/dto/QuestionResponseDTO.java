package com.nirmaan.Sample.dto;

import java.util.List;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponseDTO {
	private Long id;
	private String questionText;
	private Integer timeLimitSeconds;
	private Integer marks;
	private List<OptionResponseDTO> options;
	// Note: correctOptionIndex is not included for students
}
