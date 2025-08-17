package com.nirmaan.Sample.dto;

import com.nirmaan.Sample.entity.Feedback;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackCreateDTO {
	@NotBlank(message = "Subject is required")
	private String subject;

	@NotBlank(message = "Message is required")
	private String message;

	@NotNull(message = "Category is required")
	private Feedback.FeedbackCategory category;

	@NotNull(message = "Rating is required")
	@Min(value = 1, message = "Rating must be at least 1")
	@Max(value = 5, message = "Rating cannot exceed 5")
	private Integer rating;
}
