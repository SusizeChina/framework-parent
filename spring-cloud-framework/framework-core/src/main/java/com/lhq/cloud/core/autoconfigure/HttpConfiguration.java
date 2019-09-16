package com.lhq.cloud.core.autoconfigure;

import com.lhq.cloud.core.log.LogConstants;
import org.slf4j.MDC;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@ConditionalOnClass(RestTemplate.class)
public class HttpConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        // 使用拦截器包装http header
        restTemplate.setInterceptors(new ArrayList<ClientHttpRequestInterceptor>() {
            /**
             *
             */
            private static final long serialVersionUID = -5520031645919143950L;

            {
                add((request, body, execution) -> {
                    String traceId = MDC.get(LogConstants.LOG_TRACE_ID);
                    if (!StringUtils.isEmpty(traceId)) {
                        request.getHeaders().add(LogConstants.HTTP_HEADER_TRACE_ID, traceId);
                    }
                    return execution.execute(request, body);
                });
            }
        });

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        // 注意此处需开启缓存，否则会报getBodyInternal方法“getBody not supported”错误
        factory.setBufferRequestBody(true);
        restTemplate.setRequestFactory(factory);
        return restTemplate;
    }
}
