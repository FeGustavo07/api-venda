package com.ecommerce.venda.service.impl;

import com.ecommerce.venda.clients.BuscarProduto;
import com.ecommerce.venda.clients.MostrarProdutos;
import com.ecommerce.venda.domains.Carrinho;
import com.ecommerce.venda.dto.clients.Produto;
import com.ecommerce.venda.repositories.VendaRepository;
import com.ecommerce.venda.service.VendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class VendaServiceImpl implements VendaService {

    private final VendaRepository repository;
    private final MostrarProdutos mostrarProdutos;
    private final BuscarProduto buscarProduto;

    @Override
    public Produto[] mostrar() {
        return mostrarProdutos.executar();
    }

    @Override
    public Produto adicionarAoCarrinho(Long id) {
        var carrinho = new Carrinho();
        carrinho.setNomeProduto(buscarProduto.executar(id).getNome());
        carrinho.setPrecoProduto(buscarProduto.executar(id).getPreco());
        repository.save(carrinho);
        return buscarProduto.executar(id);
    }

    @Override
    public void limparCarrinho() {
        repository.deleteAll();
    }

    @Override
    public void removerProdutoDoCarrinho(Long id) {
        var carrinho = repository.findById(id).orElseThrow();
        repository.delete(carrinho);
    }
}
