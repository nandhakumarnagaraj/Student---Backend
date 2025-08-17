package com.nirmaan.Sample.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nirmaan.Sample.dto.ApiResponse;
import com.nirmaan.Sample.dto.FeedbackCreateDTO;
import com.nirmaan.Sample.dto.FeedbackResponseDTO;
import com.nirmaan.Sample.dto.FeedbackUpdateDTO;
import com.nirmaan.Sample.entity.Feedback;
import com.nirmaan.Sample.service.FeedbackService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/feedback")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class FeedbackController {

	private final FeedbackService feedbackService;

	@PostMapping("/create")
	public ResponseEntity<ApiResponse<FeedbackResponseDTO>> createFeedback(
			@Valid @RequestBody FeedbackCreateDTO request, @RequestParam Long studentId) {
		ApiResponse<FeedbackResponseDTO> response = feedbackService.createFeedback(request, studentId);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/all")
	public ResponseEntity<ApiResponse<List<FeedbackResponseDTO>>> getAllFeedback() {
		ApiResponse<List<FeedbackResponseDTO>> response = feedbackService.getAllFeedback();
		return ResponseEntity.ok(response);
	}

	@GetMapping("/student/{studentId}")
	public ResponseEntity<ApiResponse<List<FeedbackResponseDTO>>> getFeedbackByStudent(@PathVariable Long studentId) {
		ApiResponse<List<FeedbackResponseDTO>> response = feedbackService.getFeedbackByStudent(studentId);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/status/{status}")
	public ResponseEntity<ApiResponse<List<FeedbackResponseDTO>>> getFeedbackByStatus(
			@PathVariable Feedback.FeedbackStatus status) {
		ApiResponse<List<FeedbackResponseDTO>> response = feedbackService.getFeedbackByStatus(status);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/{feedbackId}")
	public ResponseEntity<ApiResponse<FeedbackResponseDTO>> updateFeedbackStatus(@PathVariable Long feedbackId,
			@Valid @RequestBody FeedbackUpdateDTO request) {
		ApiResponse<FeedbackResponseDTO> response = feedbackService.updateFeedbackStatus(feedbackId, request);
		return ResponseEntity.ok(response);
	}
}
