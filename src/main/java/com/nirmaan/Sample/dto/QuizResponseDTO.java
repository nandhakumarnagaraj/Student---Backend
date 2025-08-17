package com.nirmaan.Sample.dto;

import java.time.LocalDateTime;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizResponseDTO {
	private Long id;
	private String title;
	private String description;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private Integer duration;
	private Integer totalMarks;
	private Boolean isActive;
	private String createdByName;
	private Integer totalQuestions;
	private LocalDateTime createdAt;
}
