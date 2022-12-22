package com.example.bitrix.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Lead {

    private final String title;
    private final String name;
    private final String phone;
    private final String email;

}