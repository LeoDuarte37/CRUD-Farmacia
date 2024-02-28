package com.generation.farmacia.controller.dto;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
@Data
public class ItemDto {

	private Long produtoId;
	private int quantidade;
	private Long sacolaId;
}
