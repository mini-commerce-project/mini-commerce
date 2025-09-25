package com.example.minicommerce.client;

import com.example.minicommerce.global.ProviderType;

public interface OauthClient {
    ProviderType provider();
    String login(String code, String state);
}
