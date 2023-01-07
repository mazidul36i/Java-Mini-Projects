package com.masai.app.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

	@NotNull(message = "Source account is mandatory")
	private Integer srcAccno;
	@NotNull(message = "Destination account is mandatory")
	private Integer desAccno;
	@NotNull(message = "Amount is mandatory")
	@Min(value = 1, message = "Cannot transfer amount less than 1 rupee")
	private Integer amount;

}
