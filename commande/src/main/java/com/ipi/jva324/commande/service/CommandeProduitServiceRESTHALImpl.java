package com.ipi.jva324.commande.service;

import com.ipi.jva324.stock.model.ProduitEnStock;
import com.ipi.jva324.stock.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CommandeProduitServiceRESTHALImpl implements CommandeProduitService {

    @Autowired @Qualifier("springDataRestTemplate")
    private RestTemplate restTemplate;

    /** URL serveur : (configurée dans application.properties, sinon valeur par défaut) */
    @Value("${monsuperserver.url:http://localhost:8080/}")
    private String url;

    @Override
    public ProduitEnStock getProduit(long id) {
        return restTemplate.getForObject( url + "api/data-rest/produitEnStocks/" + id, ProduitEnStock.class);
    }
}
