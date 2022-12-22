package com.example.bitrix.service;

import com.example.bitrix.dto.BitrixResponseDto;
import com.example.bitrix.utils.BitrixUrlBuilder;
import com.example.bitrix.utils.CrmMethod;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;


@Service
public class BitrixService {

    @Value("${bitrix.url}")
    private String url;

    @Value("${bitrix.token}")
    private String token;

    private final RestTemplate restTemplate;

    public BitrixService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public void createLead(BitrixResponseDto dto) {
        BitrixUrlBuilder bitrixUrlBuilder = new BitrixUrlBuilder(url, token, 0)
                .createMethod(dto.getLead().getTitle(), CrmMethod.lead)
                    .addName(dto.getLead().getName())
                    .addPhone(dto.getLead().getPhone())
                    .addEmail(dto.getLead().getEmail())
                .createMethod(dto.getCompany().getTitle(), CrmMethod.company)
                    .addName(dto.getCompany().getName())
                    .addPhone(dto.getCompany().getPhone())
                    .addEmail(dto.getCompany().getEmail());

        try {
            URI uri = new URI(bitrixUrlBuilder.getRequestUrl().toString());
            restTemplate.getForObject(uri, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}