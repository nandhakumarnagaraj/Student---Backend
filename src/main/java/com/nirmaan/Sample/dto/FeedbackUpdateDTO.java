package com.nirmaan.Sample.dto;

import com.nirmaan.Sample.entity.Feedback;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackUpdateDTO {
	@NotNull(message = "Status is required")
	private Feedback.FeedbackStatus status;

	private String adminResponse;
}