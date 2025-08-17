package com.nirmaan.Sample.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.nirmaan.Sample.entity.Attendance;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceResponseDTO {
	private Long id;
	private String studentName;
	private String studentId;
	private String subject;
	private LocalDate attendanceDate;
	private Attendance.AttendanceStatus status;
	private String remarks;
	private String teacherName;
	private LocalDateTime createdAt;
}