package com.example.minicommerce.client;

import static org.springframework.http.MediaType.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;

import com.example.minicommerce.global.dto.GetOauthTokenResponseDto;
import com.example.minicommerce.global.ProviderType;

@Component
public class NaverOauthClient implements OauthClient {

    RestClient restClient = RestClient.create();

    @Value("${NAVER_TOKEN_URI}")
    private String naverTokenUri;

    @Value("${NAVER_SECRET}")
    private String naverSecret;

    @Value("${NAVER_CLIENT_ID}")
    private String naverClientId;

    @Override
    public ProviderType provider() {
        return ProviderType.NAVER;
    }

    /*
    요청 변수
      - grant_type: authorization_code
      - client_id   // 웹 어플리케이션을 구분할 수 있는 식별자
      - client_secret   // client ID에 대한 비밀키
      - code: 콜백으로 받은 code
      - state: 콜백으로 받은 state
    */
    @Override
    public GetOauthTokenResponseDto getToken(String code, String state) {
        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("grant_type", "authorization_code");
        form.add("client_id", naverClientId);
        form.add("client_secret", naverSecret);
        form.add("code", code);
        form.add("state", state);

        return restClient.post()
            .uri(naverTokenUri)
            .contentType(APPLICATION_FORM_URLENCODED)
            .body(form)
            .retrieve()
            .body(GetOauthTokenResponseDto.class);
    }
}
