package com.example.minicommerce;


public class NaverRequestDto {
    private String grantType = "authorization_code";
    private String clientId;
    private String clientSecret;
    private String code;
    private String state;

    public NaverRequestDto(String clientId, String clientSecret, String code, String state) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.code = code;
        this.state = state;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getCode() {
        return code;
    }

    public String getState() {
        return state;
    }

    public String getGrantType() {
        return grantType;
    }

    @Override
    public String toString() {
        return "NaverRequestDto{" +
            "grantType='" + grantType + '\'' +
            ", clientId='" + clientId + '\'' +
            ", clientSecret='" + clientSecret + '\'' +
            ", code='" + code + '\'' +
            ", state='" + state + '\'' +
            '}';
    }
}
