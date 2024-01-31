package com.generation.farmacia.service;

import com.generation.farmacia.controller.dto.ItemDto;
import com.generation.farmacia.model.Item;
import com.generation.farmacia.model.Sacola;

public interface SacolaService {
	
	Item incluirNaSacola(ItemDto itemDto);
	Sacola verSacola(Long id);
	Sacola fecharSacola(Long id, int formaPagamento);
}
