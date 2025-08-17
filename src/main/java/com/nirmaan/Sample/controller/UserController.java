package com.nirmaan.Sample.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nirmaan.Sample.dto.ApiResponse;
import com.nirmaan.Sample.dto.UserResponseDTO;
import com.nirmaan.Sample.entity.User;
import com.nirmaan.Sample.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {

	private final UserService userService;

	@GetMapping
	public ResponseEntity<ApiResponse<List<UserResponseDTO>>> getAllUsers() {
		ApiResponse<List<UserResponseDTO>> response = userService.getAllUsers();
		return ResponseEntity.ok(response);
	}

	@GetMapping("/role/{role}")
	public ResponseEntity<ApiResponse<List<UserResponseDTO>>> getUsersByRole(@PathVariable User.UserRole role) {
		ApiResponse<List<UserResponseDTO>> response = userService.getUsersByRole(role);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<UserResponseDTO>> getUserById(@PathVariable Long id) {
		ApiResponse<UserResponseDTO> response = userService.getUserById(id);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/{id}/status")
	public ResponseEntity<ApiResponse<UserResponseDTO>> updateUserStatus(@PathVariable Long id,
			@RequestParam boolean isActive) {
		ApiResponse<UserResponseDTO> response = userService.updateUserStatus(id, isActive);
		return ResponseEntity.ok(response);
	}
}