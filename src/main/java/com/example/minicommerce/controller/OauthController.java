package com.example.minicommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.minicommerce.global.GetOauthTokenResponseDto;
import com.example.minicommerce.service.OauthService;

@RestController
public class OauthController {

    private final OauthService oauthService;

    public OauthController(OauthService oauthService) {
        this.oauthService = oauthService;
    }

    @GetMapping("/{provider}")
    public GetOauthTokenResponseDto getOauthToken(
        @PathVariable String provider,
        @RequestParam(required = false) String code,
        @RequestParam(required = false) String state
    ) {
        return oauthService.getOauthToken(provider, code, state);
    }
}
