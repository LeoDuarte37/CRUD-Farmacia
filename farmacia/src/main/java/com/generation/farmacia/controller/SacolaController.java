package com.generation.farmacia.controller;

import com.generation.farmacia.controller.dto.ItemDto;
import com.generation.farmacia.model.Item;
import com.generation.farmacia.model.Sacola;
import com.generation.farmacia.service.SacolaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sacolas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class SacolaController {

    private final SacolaService sacolaService;

    @GetMapping("/{id}")
    public Sacola verSacola(@PathVariable("id") Long id) {
        return sacolaService.verSacola(id);
    }

    @PostMapping
    public Item incluirNaSacola(@RequestBody ItemDto itemDto) {
        return sacolaService.incluirNaSacola(itemDto);
    }

    @PutMapping("/fecharSacola/{id}")
    public Sacola fecharSacola(@PathVariable("id") Long id, @RequestBody int formaPagamento) {
        return sacolaService.fecharSacola(id, formaPagamento);
    }
}
