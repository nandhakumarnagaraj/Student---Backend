package com.nirmaan.Sample.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false)
    private String firstName;
    
    @Column(nullable = false)
    private String lastName;
    
    @Column(nullable = false)
    private String phoneNumber;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;
    
    @Column(nullable = false)
    private Boolean isActive = true;
    
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    
    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
    
    // For students - additional fields
    private String studentId;
    private String department;
    private Integer semester;
    
    // Relationships
    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL)
    private List<Quiz> createdQuizzes;
    
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<QuizAttempt> quizAttempts;
    
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Attendance> attendanceRecords;
    
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Feedback> feedbacks;
    
    public enum UserRole {
        ADMIN, TEACHER, STUDENT
    }
}