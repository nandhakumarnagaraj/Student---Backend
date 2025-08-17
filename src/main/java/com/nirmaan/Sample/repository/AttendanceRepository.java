package com.nirmaan.Sample.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nirmaan.Sample.entity.Attendance;
import com.nirmaan.Sample.entity.User;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByStudent(User student);
    List<Attendance> findByTeacher(User teacher);
    List<Attendance> findByAttendanceDate(LocalDate date);
    List<Attendance> findByStudentAndAttendanceDate(User student, LocalDate date);
    
    @Query("SELECT a FROM Attendance a WHERE a.student = :student AND a.attendanceDate BETWEEN :startDate AND :endDate")
    List<Attendance> findByStudentAndDateRange(@Param("student") User student, 
                                             @Param("startDate") LocalDate startDate, 
                                             @Param("endDate") LocalDate endDate);
    
    @Query("SELECT COUNT(a) FROM Attendance a WHERE a.student = :student AND a.status = :status")
    Long countByStudentAndStatus(@Param("student") User student, @Param("status") Attendance.AttendanceStatus status);
}

