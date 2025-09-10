package com.example.minicommerce;

import static org.springframework.http.MediaType.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping()
public class OauthController {

    RestClient restClient = RestClient.create();

    @Value("${NAVER_SECRET}")
    private String naverSecret;

    @Value("${NAVER_TOKEN_URI}")
    private String naverTokenUri;

    @Value("${KAKAO_SECRET}")
    private String kakaoSecret;

    @Value("${KAKAO_TOKEN_URI}")
    private String kakaoTokenUri;

    @Value("${KAKAO_Redirect_URI}")
    private String kakaoRedirectUri;


    /*
        요청 변수
          - grant_type: authorization_code
          - client_id   // 웹 어플리케이션을 구분할 수 있는 식별자
          - client_secret   // client ID에 대한 비밀키
          - code: 콜백으로 받은 code
          - state: 콜백으로 받은 state
     */
    @GetMapping("/login/callback")
    public String naverLogin(
        @RequestParam("code") String code,
        @RequestParam("state") String state
    ) {
        
        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("grant_type", "authorization_code");
        form.add("client_id", "1qDu4kPdBqi8w9BYsgKV");
        form.add("client_secret", naverSecret);
        form.add("code", code);
        form.add("state", state);

        String token = restClient.post()
            .uri(naverTokenUri)
            .contentType(APPLICATION_FORM_URLENCODED)
            .body(form)
            .retrieve()
            .body(String.class);

        System.out.println("token = " + token);
        
        return token;
    }

    /*
     * Content-Type : application/x-www-form-urlencoded;charset=utf-8
     * grant_type : authorization_code
     * client_id : REST API 키
     * redirect_uri
     * code
     */
    @GetMapping("/kakao")
    public String kakao(@RequestParam String code) {
        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("grant_type", "authorization_code");
        form.add("client_id", "f152c5f5fd6cf53bc8a821b474a2accf");
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
