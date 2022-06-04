package com.ecommerce.venda.service;

import com.ecommerce.venda.dto.clients.Produto;

public interface VendaService {
    Produto[] mostrar();
    Produto adicionarAoCarrinho(Long id);
    void limparCarrinho();
    void removerProdutoDoCarrinho(Long id);
}
