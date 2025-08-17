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
import com.nirmaan.Sample.dto.AttendanceCreateDTO;
import com.nirmaan.Sample.dto.AttendanceResponseDTO;
import com.nirmaan.Sample.dto.AttendanceStatsDTO;
import com.nirmaan.Sample.dto.BulkAttendanceDTO;
import com.nirmaan.Sample.service.AttendanceService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/attendance")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AttendanceController {

	private final AttendanceService attendanceService;

	@PostMapping("/mark")
	public ResponseEntity<ApiResponse<AttendanceResponseDTO>> markAttendance(
			@Valid @RequestBody AttendanceCreateDTO request, @RequestParam Long teacherId) {
		ApiResponse<AttendanceResponseDTO> response = attendanceService.markAttendance(request, teacherId);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/bulk")
	public ResponseEntity<ApiResponse<List<AttendanceResponseDTO>>> markBulkAttendance(
			@Valid @RequestBody BulkAttendanceDTO request, @RequestParam Long teacherId) {
		ApiResponse<List<AttendanceResponseDTO>> response = attendanceService.markBulkAttendance(request, teacherId);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/student/{studentId}")
	public ResponseEntity<ApiResponse<List<AttendanceResponseDTO>>> getStudentAttendance(@PathVariable Long studentId) {
		ApiResponse<List<AttendanceResponseDTO>> response = attendanceService.getStudentAttendance(studentId);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/student/{studentId}/stats")
	public ResponseEntity<ApiResponse<AttendanceStatsDTO>> getStudentAttendanceStats(@PathVariable Long studentId) {
		ApiResponse<AttendanceStatsDTO> response = attendanceService.getStudentAttendanceStats(studentId);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/teacher/{teacherId}")
	public ResponseEntity<ApiResponse<List<AttendanceResponseDTO>>> getAttendanceByTeacher(
			@PathVariable Long teacherId) {
		ApiResponse<List<AttendanceResponseDTO>> response = attendanceService.getAttendanceByTeacher(teacherId);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/date/{date}")
	public ResponseEntity<ApiResponse<List<AttendanceResponseDTO>>> getAttendanceByDate(@PathVariable String date) {
		ApiResponse<List<AttendanceResponseDTO>> response = attendanceService
				.getAttendanceByDate(java.time.LocalDate.parse(date));
		return ResponseEntity.ok(response);
	}
}
