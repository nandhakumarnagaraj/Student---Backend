package com.nirmaan.Sample.dto;

import com.nirmaan.Sample.entity.Attendance;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentAttendanceDTO {
	@NotNull(message = "Student ID is required")
	private Long studentId;

	@NotNull(message = "Status is required")
	private Attendance.AttendanceStatus status;

	private String remarks;
}
