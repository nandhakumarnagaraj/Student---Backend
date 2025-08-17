package com.nirmaan.Sample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizCreateDTO {
	@NotBlank(message = "Quiz title is required")
	private String title;

	private String description;

	@NotNull(message = "Start time is required")
	private LocalDateTime startTime;

	@NotNull(message = "End time is required")
	private LocalDateTime endTime;

	@NotNull(message = "Duration is required")
	@Min(value = 1, message = "Duration must be at least 1 minute")
	private Integer duration;

	@NotNull(message = "Total marks is required")
	@Min(value = 1, message = "Total marks must be at least 1")
	private Integer totalMarks;

	private List<QuestionCreateDTO> questions;
}
