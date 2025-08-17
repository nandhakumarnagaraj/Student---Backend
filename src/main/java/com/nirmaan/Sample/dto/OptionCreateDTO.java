package com.nirmaan.Sample.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OptionCreateDTO {
	@NotBlank(message = "Option text is required")
	private String text;

	@NotNull(message = "Option index is required")
	private Integer index;
}
