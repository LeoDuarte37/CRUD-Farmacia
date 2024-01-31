package com.generation.farmacia.controller.dto;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class ItemDto {

	private Long produtoId;
	private int quantidade;
	private Long sacolaId;
}
