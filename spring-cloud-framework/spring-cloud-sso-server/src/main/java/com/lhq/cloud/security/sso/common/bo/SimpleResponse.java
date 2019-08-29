package com.lhq.cloud.security.sso.common.bo;

public class SimpleResponse {

    String content;

    String loginUrl;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public SimpleResponse(String content, String loginUrl) {
        this.content = content;
        this.loginUrl = loginUrl;
    }
}

