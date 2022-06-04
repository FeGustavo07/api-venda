package com.ecommerce.venda.repositories;

import com.ecommerce.venda.domains.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Carrinho, Long> {
}
