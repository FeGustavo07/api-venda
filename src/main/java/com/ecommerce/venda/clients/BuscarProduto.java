package com.ecommerce.venda.clients;

import com.ecommerce.venda.dto.clients.Produto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
public class BuscarProduto {

    @Value("http://localhost:8081/produto/{id}")
    private String url;


    public Produto executar(@PathVariable("id") Long id) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<Produto> produtoResponseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                Produto.class,
                id
        );

        return produtoResponseEntity.getBody();
    }
}
