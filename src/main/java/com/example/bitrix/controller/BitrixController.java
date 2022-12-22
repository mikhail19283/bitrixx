package com.example.bitrix.controller;

import com.example.bitrix.service.BitrixService;
import com.example.bitrix.dto.BitrixResponseDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class BitrixController {

    private final BitrixService bitrixService;

    public BitrixController(BitrixService bitrixService) {
        this.bitrixService = bitrixService;
    }

    @PostMapping("/add")
    public void addLeadAndCompany(@RequestBody BitrixResponseDto dto) {
        bitrixService.createLead(dto);
    }

}