package com.example.minicommerce.client;

import com.example.minicommerce.OauthLoginResponseDto;
import com.example.minicommerce.global.ProviderType;

public interface OauthClient {
    ProviderType provider();
    OauthLoginResponseDto login(String code, String state);
}
