package com.ecommerce.venda.dto.clients;

import lombok.Getter;

@Getter
public class Produto {
    private Long id;
    private String nome;
    private String descricao;
    private String categoria;
    private double preco;
}
