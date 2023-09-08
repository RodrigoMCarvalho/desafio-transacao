package com.rodrigo.picpay.service;

import com.rodrigo.picpay.domain.dto.AuthorizerMock;
import com.rodrigo.picpay.exception.ServiceUnavailableException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Slf4j
@Service
public class AuthorizerMockService {

    @Value("${url.authorizer.mock}")
    private String urlAuthorizerMock;

    public AuthorizerMock getAuthorizerMock() {
        try{
            RestTemplate restTemplate = new RestTemplate();
            log.info("Realizando consulta no serviço autorizador mock, URL: {}", urlAuthorizerMock);
            AuthorizerMock response = restTemplate.getForEntity(urlAuthorizerMock, AuthorizerMock.class).getBody();
            log.info("Resposta do serviço autorizador mock: {}", response);
            return response;
        }catch (Exception ex) {
            log.error("Falha para consultar o serviço autorizador mock, erro: {}", ex.getMessage());
            throw new ServiceUnavailableException("Serviço indisponível");
        }
    }
}
