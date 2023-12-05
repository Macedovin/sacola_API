package com.macedovingithub.sacolaApi.service.impl;

import com.macedovingithub.sacolaApi.enumeration.FormaPagamento;
import com.macedovingithub.sacolaApi.model.Item;
import com.macedovingithub.sacolaApi.model.Sacola;
import com.macedovingithub.sacolaApi.repository.IItemRepository;
import com.macedovingithub.sacolaApi.repository.IProdutoRepository;
import com.macedovingithub.sacolaApi.repository.ISacolaRepository;
import com.macedovingithub.sacolaApi.resource.dto.ItemDto;
import com.macedovingithub.sacolaApi.service.ISacolaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SacolaSerivceImpl implements ISacolaService {

    private final ISacolaRepository sacolaRepository;

    private final IProdutoRepository produtoRepository;

    private final IItemRepository itemRerpository;

    @Override
    public Sacola verSacola(Long id) {
        return sacolaRepository.findById(id).orElseThrow(
                () -> {
                    throw new RuntimeException("Esta sacola não existe!");
                }
        );
    }

    @Override
    public Sacola fecharSacola(Long id, int formaDePagamento) {
        Sacola sacola = verSacola(id);

        if (sacola.getItens().isEmpty()) {
            throw new RuntimeException("Inclua itens na sacola!");
        }

        FormaPagamento formaPagamento = formaDePagamento == 0 ? FormaPagamento.DINHEIRO : FormaPagamento.MAQUINETA;

        sacola.setFormaPagamento(formaPagamento);
        sacola.setFechada(true);

        return sacolaRepository.save(sacola);
    }

    @Override
    public Item incluirItemNaSacola(ItemDto itemDto) {
        return null;
    }
}