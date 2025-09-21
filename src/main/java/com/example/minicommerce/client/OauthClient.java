package com.example.minicommerce.client;

import org.springframework.stereotype.Component;

import com.example.minicommerce.global.ProviderType;

@Component
public interface OauthClient {
    ProviderType provider();
    String login(String code, String state);
}
