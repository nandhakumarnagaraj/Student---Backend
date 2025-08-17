package com.nirmaan.Sample.dto;

import com.nirmaan.Sample.entity.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDTO {
	@Email(message = "Please provide a valid email")
	@NotBlank(message = "Email is required")
	private String email;

	@NotBlank(message = "Password is required")
	private String password;

	@NotBlank(message = "First name is required")
	private String firstName;

	@NotBlank(message = "Last name is required")
	private String lastName;

	@NotBlank(message = "Phone number is required")
	private String phoneNumber;

	@NotNull(message = "Role is required")
	private User.UserRole role;

	// Student specific fields
	private String studentId;
	private String department;
	private Integer semester;
}