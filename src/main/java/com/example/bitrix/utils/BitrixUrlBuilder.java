package com.example.bitrix.utils;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class BitrixUrlBuilder {

    private final StringBuilder requestUrl = new StringBuilder();

    public BitrixUrlBuilder(String url, String token, Integer halt) {
        requestUrl.append(url);
        requestUrl.append(token);
        requestUrl.append("/batch?halt=");
        requestUrl.append(halt);
    }

    public StringBuilder getRequestUrl() {
        return requestUrl;
    }

    public BitrixUrlBuilder createMethod(String title, CrmMethod method) {
        requestUrl.append("&cmd[create_")
                .append(method)
                .append("]=crm.")
                .append(method)
                .append(".add")
                .append(encode("?FIELDS[TITLE]=" + title));
        return this;
    }

    public BitrixUrlBuilder addName(String name) {
        requestUrl.append(encode("&FIELDS[NAME]=" + name));
        return this;
    }

    public BitrixUrlBuilder addPhone(String phone) {
        requestUrl.append(encode("&FIELDS[PHONE][0][VALUE]=" + phone));
        requestUrl.append(encode("&FIELDS[PHONE][0][VALUE_TYPE]=WORK"));
        return this;
    }

    public BitrixUrlBuilder addEmail(String email) {
        requestUrl.append(encode("&FIELDS[EMAIL][0][VALUE]=" + email));
        requestUrl.append(encode("&FIELDS[EMAIL][0][VALUE_TYPE]=WORK"));
        return this;
    }

    private String encode(String string) {
        return URLEncoder.encode(string, StandardCharsets.UTF_8);
    }

}