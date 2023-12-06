package com.macedovingithub.sacolaApi.service.impl;

import com.macedovingithub.sacolaApi.enumeration.FormaPagamento;
import com.macedovingithub.sacolaApi.model.Item;
import com.macedovingithub.sacolaApi.model.Restaurante;
import com.macedovingithub.sacolaApi.model.Sacola;
import com.macedovingithub.sacolaApi.repository.IItemRepository;
import com.macedovingithub.sacolaApi.repository.IProdutoRepository;
import com.macedovingithub.sacolaApi.repository.ISacolaRepository;
import com.macedovingithub.sacolaApi.resource.dto.ItemDto;
import com.macedovingithub.sacolaApi.service.ISacolaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        Sacola sacola = verSacola(itemDto.getIdSacola());

        if (sacola.isFechada()) {
            throw new RuntimeException("Esta sacola já esta fechada.");
        }

        Item itemParaSerInserido = Item.builder()
            .quantidade(itemDto.getQuantidade())
            .sacola(sacola)
            .produto(produtoRepository.findById(itemDto.getProdutoId()).orElseThrow(
                    () -> {
                        throw new RuntimeException("Este produto não existe.");
                    }
            ))
            .build();

        List<Item> itensDaSacola = sacola.getItens();

        if (itensDaSacola.isEmpty()) {
            itensDaSacola.add(itemParaSerInserido);
        } else {
            Restaurante restauranteAtual = itensDaSacola.get(0).getProduto().getRestaurante();

            Restaurante restauranteDoItemParaAdicionar = itemParaSerInserido.getProduto().getRestaurante();

            if (restauranteAtual.equals(restauranteDoItemParaAdicionar)) {
                itensDaSacola.add(itemParaSerInserido);
            } else {
                throw new RuntimeException("Não é possível adicionar produtos de restaurantes diferentes. Feche a sacola ou a esvazie.");
            }
        }

        List<Double> valorDosItens = new ArrayList<>();

        for (Item itemDaSacola : itensDaSacola) {;

            double valorTotalItem = itemDaSacola.getProduto().getValorUnitario() * itemDaSacola.getQuantidade();

            valorDosItens.add(valorTotalItem);
        }

        Double valorTotalSacola = 0.0;

        for (Double valorDeCadaItem : valorDosItens) {
            valorTotalSacola += valorDeCadaItem;
        }

        // Utilizando Stream API
//        double valorTotalSacola = valorDosItens.stream()
//            .mapToDouble(valorTotalDeCadaItem -> valorTotalDeCadaItem)
//            .sum();

        sacola.setValorTotal(valorTotalSacola);

        sacolaRepository.save(sacola);

        return itemRerpository.save(itemParaSerInserido);
    }
}
