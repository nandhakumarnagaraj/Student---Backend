package com.nirmaan.Sample.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BulkAttendanceDTO {
    @NotNull(message = "Attendance date is required")
    private LocalDate attendanceDate;
    
    @NotBlank(message = "Subject is required")
    private String subject;
    
    @NotNull(message = "Attendance records are required")
    private List<StudentAttendanceDTO> attendanceRecords;
}