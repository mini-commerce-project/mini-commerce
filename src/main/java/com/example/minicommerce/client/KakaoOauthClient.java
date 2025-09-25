package com.example.minicommerce.client;

import static org.springframework.http.MediaType.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;

import com.example.minicommerce.global.ProviderType;

@Component
public class KakaoOauthClient implements OauthClient {

    RestClient restClient = RestClient.create();

    @Value("${KAKAO_SECRET}")
    private String kakaoSecret;

    @Value("${KAKAO_Redirect_URI}")
    private String kakaoRedirectUri;

    @Value("${KAKAO_TOKEN_URI}")
    private String kakaoTokenUri;

    @Value("${KAKAO_CLIENT_ID}")
    private String kakaoClientId;

    @Override
    public ProviderType provider() {
        return ProviderType.KAKAO;
    }

    /*
     * Content-Type : application/x-www-form-urlencoded;charset=utf-8
     * grant_type : authorization_code
     * client_id : REST API 키
     * redirect_uri
     * code
     */
    @Override
    public String login(String code, String state) {
        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("grant_type", "authorization_code");
        form.add("client_id", kakaoClientId);
        form.add("client_secret", kakaoSecret);
        form.add("code", code);
        form.add("redirect_uri", kakaoRedirectUri);

        return restClient.post()
            .uri(kakaoTokenUri)
            .contentType(APPLICATION_FORM_URLENCODED)
            .body(form)
            .retrieve()
            .body(String.class);
    }
}
