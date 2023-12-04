package com.macedovingithub.sacolaApi.service;

import com.macedovingithub.sacolaApi.model.Item;
import com.macedovingithub.sacolaApi.model.Sacola;
import com.macedovingithub.sacolaApi.resource.dto.ItemDto;

public interface ISacolaService {

    Sacola verSacola(Long id);
    Sacola fecharSacola(Long id, int formaDePagamento);
    Item incluirItemNaSacola(ItemDto itemDto);
}
