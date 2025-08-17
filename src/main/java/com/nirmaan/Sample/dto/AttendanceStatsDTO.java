package com.nirmaan.Sample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@AllArgsConstructor

public class AttendanceStatsDTO {
	private Long totalClasses;
	private Long presentCount;
	private Long absentCount;
	private Long lateCount;
	private Double attendancePercentage;
}