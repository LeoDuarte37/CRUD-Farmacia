package com.generation.farmacia.service.impl;

import com.generation.farmacia.controller.dto.ItemDto;
import com.generation.farmacia.enumeration.FormaPagamento;
import com.generation.farmacia.model.Item;
import com.generation.farmacia.model.Sacola;
import com.generation.farmacia.repository.ItemRepository;
import com.generation.farmacia.repository.ProdutoRepository;
import com.generation.farmacia.repository.SacolaRepository;
import com.generation.farmacia.service.SacolaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SacolaServiceImpl implements SacolaService {

    @Autowired
    private SacolaRepository sacolaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Sacola verSacola(Long id) {
        return sacolaRepository.findById(id).orElseThrow(
                () -> {
                    throw new RuntimeException("Essa sacola não existe!");
                }
        );
    }

    @Override
    public Item incluirNaSacola(ItemDto itemDto) {
        Sacola sacola = verSacola(itemDto.getSacolaId());

        if (sacola.isFechada()) {
            throw new RuntimeException("Essa sacola está fechada!");
        }

        Item itemForInserction = Item.builder()
                .quantidade(itemDto.getQuantidade())
                .sacola(sacola)
                .produto(produtoRepository.findById(itemDto.getProdutoId()).orElseThrow(
                        () -> {
                            throw new RuntimeException("Esse produto não existe!");
                        }
                ))
                .build();

        sacola.getItens().add(itemForInserction);

        sacolaRepository.save(sacola);
        return itemRepository.save(itemForInserction);
    }


    @Override
    public Sacola fecharSacola(Long id, int formaPagamento) {
        Sacola sacola = verSacola(id);
        if (sacola.getItens().isEmpty()) {
            throw new RuntimeException("Inclua itens na sacola!");
        }

        FormaPagamento forma = formaPagamento == 0 ? FormaPagamento.DINHEIRO : FormaPagamento.CARTAO;

        sacola.setFormaPagamento(forma);
        sacola.setFechada(true);

        return sacolaRepository.save(sacola);
    }
}
