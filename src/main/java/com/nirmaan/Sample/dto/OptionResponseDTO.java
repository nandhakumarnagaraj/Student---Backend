package com.nirmaan.Sample.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OptionResponseDTO {
	private Long id;
	private String text;
	private Integer index;
}
