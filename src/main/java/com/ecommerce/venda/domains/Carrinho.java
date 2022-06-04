package com.ecommerce.venda.domains;

import com.ecommerce.venda.dto.clients.Produto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@RequiredArgsConstructor
public class Carrinho {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String NomeProduto;

    @Column
    private double precoProduto;
}
