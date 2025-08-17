package com.nirmaan.Sample.dto;

import java.time.LocalDate;

import com.nirmaan.Sample.entity.Attendance;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceCreateDTO {
    @NotNull(message = "Student ID is required")
    private Long studentId;
    
    @NotBlank(message = "Subject is required")
    private String subject;
    
    @NotNull(message = "Attendance date is required")
    private LocalDate attendanceDate;
    
    @NotNull(message = "Status is required")
    private Attendance.AttendanceStatus status;
    
    private String remarks;
}