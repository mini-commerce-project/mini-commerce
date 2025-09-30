package com.example.minicommerce.client;

import com.example.minicommerce.global.dto.GetOauthTokenResponseDto;
import com.example.minicommerce.global.ProviderType;

public interface OauthClient {
    ProviderType provider();
    GetOauthTokenResponseDto getToken(String code, String state);
}
