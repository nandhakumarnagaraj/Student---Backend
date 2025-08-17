package com.nirmaan.Sample.dto;

import java.util.List;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionCreateDTO {
	@NotBlank(message = "Question text is required")
	private String questionText;

	@NotNull(message = "Time limit is required")
	@Min(value = 10, message = "Time limit must be at least 10 seconds")
	private Integer timeLimitSeconds;

	@NotNull(message = "Marks is required")
	@Min(value = 1, message = "Marks must be at least 1")
	private Integer marks;

	@NotNull(message = "Correct option index is required")
	private Integer correctOptionIndex;

	private List<OptionCreateDTO> options;
}
