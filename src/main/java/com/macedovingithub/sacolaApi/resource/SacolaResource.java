package com.macedovingithub.sacolaApi.resource;

import com.macedovingithub.sacolaApi.model.Item;
import com.macedovingithub.sacolaApi.model.Sacola;
import com.macedovingithub.sacolaApi.resource.dto.ItemDto;
import com.macedovingithub.sacolaApi.service.ISacolaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ifood-devweek/sacolas")
@RequiredArgsConstructor
public class SacolaResource {

    private final ISacolaService sacolaService;

    @PostMapping
    public Item incluirItemNaSacola(@RequestBody ItemDto itemDto) {
        return sacolaService.incluirItemNaSacola(itemDto);
    }

    @GetMapping("/{id}")
    public Sacola verSacola(@PathVariable Long id){
        return sacolaService.verSacola(id);
    }

    @PatchMapping("/fecharSacola/{sacolaId}")
    public Sacola fecharSacola(@PathVariable("sacolaId") Long sacolaId,
                               @RequestParam("formaPagamento") int formaDePagamento){
        return sacolaService.fecharSacola(sacolaId, formaDePagamento);
    }
}
