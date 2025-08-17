package com.nirmaan.Sample.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nirmaan.Sample.dto.ApiResponse;
import com.nirmaan.Sample.dto.QuestionResponseDTO;
import com.nirmaan.Sample.dto.QuizAttemptDTO;
import com.nirmaan.Sample.dto.QuizCreateDTO;
import com.nirmaan.Sample.dto.QuizResponseDTO;
import com.nirmaan.Sample.dto.QuizResultDTO;
import com.nirmaan.Sample.dto.SubmitQuizDTO;
import com.nirmaan.Sample.service.QuizService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/quiz")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class QuizController {

	private final QuizService quizService;

	@PostMapping("/create")
	public ResponseEntity<ApiResponse<QuizResponseDTO>> createQuiz(@Valid @RequestBody QuizCreateDTO request,
			@RequestParam Long teacherId) {
		ApiResponse<QuizResponseDTO> response = quizService.createQuiz(request, teacherId);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/all")
	public ResponseEntity<ApiResponse<List<QuizResponseDTO>>> getAllActiveQuizzes() {
		ApiResponse<List<QuizResponseDTO>> response = quizService.getAllActiveQuizzes();
		return ResponseEntity.ok(response);
	}

	@GetMapping("/teacher/{teacherId}")
	public ResponseEntity<ApiResponse<List<QuizResponseDTO>>> getQuizzesByTeacher(@PathVariable Long teacherId) {
		ApiResponse<List<QuizResponseDTO>> response = quizService.getQuizzesByTeacher(teacherId);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{quizId}/questions")
	public ResponseEntity<ApiResponse<List<QuestionResponseDTO>>> getQuizQuestions(@PathVariable Long quizId,
			@RequestParam Long studentId) {
		ApiResponse<List<QuestionResponseDTO>> response = quizService.getQuizQuestions(quizId, studentId);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/{quizId}/start")
	public ResponseEntity<ApiResponse<QuizAttemptDTO>> startQuiz(@PathVariable Long quizId,
			@RequestParam Long studentId) {
		ApiResponse<QuizAttemptDTO> response = quizService.startQuiz(quizId, studentId);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/submit")
	public ResponseEntity<ApiResponse<QuizResultDTO>> submitQuiz(@Valid @RequestBody SubmitQuizDTO request,
			@RequestParam Long studentId) {
		ApiResponse<QuizResultDTO> response = quizService.submitQuiz(request, studentId);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/attempts/student/{studentId}")
	public ResponseEntity<ApiResponse<List<QuizAttemptDTO>>> getStudentQuizAttempts(@PathVariable Long studentId) {
		ApiResponse<List<QuizAttemptDTO>> response = quizService.getStudentQuizAttempts(studentId);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{quizId}/results")
	public ResponseEntity<ApiResponse<List<QuizAttemptDTO>>> getQuizResults(@PathVariable Long quizId,
			@RequestParam Long teacherId) {
		ApiResponse<List<QuizAttemptDTO>> response = quizService.getQuizResults(quizId, teacherId);
		return ResponseEntity.ok(response);
	}
}