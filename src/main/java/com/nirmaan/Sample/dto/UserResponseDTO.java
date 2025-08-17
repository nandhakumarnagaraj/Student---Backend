package com.nirmaan.Sample.dto;

import com.nirmaan.Sample.entity.User;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
	private Long id;
	private String email;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private User.UserRole role;
	private Boolean isActive;
	private String studentId;
	private String department;
	private Integer semester;
}
