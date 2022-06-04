package com.ecommerce.venda.clients;

import com.ecommerce.venda.dto.clients.Produto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MostrarProdutos {

    @Value("http://localhost:8081/produto")
    private String url;

    public Produto[] executar() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<Produto[]> produtoResponseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                Produto[].class
        );

        return produtoResponseEntity.getBody();
    }
}

