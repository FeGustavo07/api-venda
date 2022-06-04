package com.ecommerce.venda.controllers;

import com.ecommerce.venda.dto.clients.Produto;
import com.ecommerce.venda.service.VendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/venda")
@RequiredArgsConstructor
public class VendaController {

    private final VendaService vendaService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("/mostrarProdutos")
    public Produto[] mostrar() {
        return vendaService.mostrar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping("/adicionar/{id}")
    public Produto adicionarCarrinho(@PathVariable Long id) {
        return vendaService.adicionarAoCarrinho(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("/limparCarrinho")
    public void limparCarrinho() {
        vendaService.limparCarrinho();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("/limparCarrinho/{id}")
    public void excluirItemDoCarrinho(@PathVariable Long id) {
        vendaService.adicionarAoCarrinho(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String concluirVenda() {
        vendaService.limparCarrinho();
        return "Venda Concluída com Sucesso!";
    }
}
