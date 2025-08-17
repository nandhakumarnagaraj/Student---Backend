package com.nirmaan.Sample.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nirmaan.Sample.dto.ApiResponse;
import com.nirmaan.Sample.dto.LoginRequestDTO;
import com.nirmaan.Sample.dto.RegisterRequestDTO;
import com.nirmaan.Sample.dto.UserResponseDTO;
import com.nirmaan.Sample.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {

	private final UserService userService;

	@PostMapping("/register")
	public ResponseEntity<ApiResponse<UserResponseDTO>> register(@Valid @RequestBody RegisterRequestDTO request) {
		ApiResponse<UserResponseDTO> response = userService.registerUser(request);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/login")
	public ResponseEntity<ApiResponse<UserResponseDTO>> login(@Valid @RequestBody LoginRequestDTO request) {
		ApiResponse<UserResponseDTO> response = userService.loginUser(request);
		return ResponseEntity.ok(response);
	}
}
