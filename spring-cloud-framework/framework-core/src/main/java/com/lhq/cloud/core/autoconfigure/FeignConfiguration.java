package com.lhq.cloud.core.autoconfigure;

import com.lhq.cloud.core.fegin.FeginRequestInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;

public class FeignConfiguration {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new FeginRequestInterceptor();
    }

}
