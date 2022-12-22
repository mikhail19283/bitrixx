package com.example.bitrix.dto;

import com.example.bitrix.entity.Company;
import com.example.bitrix.entity.Lead;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BitrixResponseDto {

    private final Integer formId;
    private final Lead lead;
    private final Company company;

}