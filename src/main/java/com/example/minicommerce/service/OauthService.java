package com.example.minicommerce.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.minicommerce.OauthLoginResponseDto;
import com.example.minicommerce.global.ProviderType;
import com.example.minicommerce.client.OauthClient;

@Service
public class OauthService {

    private final Map<ProviderType, OauthClient> clients = new HashMap<>();

    public OauthService(List<OauthClient> clientList) {
        // 구현체들을 순회하면서 enum 기반으로 매핑
        for (OauthClient client : clientList) {
            clients.put(client.provider(), client);
        }
    }

    public OauthLoginResponseDto oauthLogin(String provider, String code, String state) {
        OauthClient oauthClient = clients.get(ProviderType.valueOf(provider.toUpperCase()));
        return oauthClient.login(code, state);
    }
}
