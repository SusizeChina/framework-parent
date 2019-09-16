package com.lhq.cloud.core.autoconfigure;

import com.lhq.cloud.core.log.InterceptorConfiguration;
import com.lhq.cloud.core.log.TraceLogHandlerInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@ConditionalOnClass(WebMvcConfigurerAdapter.class)
public class LogConfiguration {

    @Bean
    @ConditionalOnClass(TraceLogHandlerInterceptor.class)
    public TraceLogHandlerInterceptor traceLogHandlerInterceptor() {
        return new TraceLogHandlerInterceptor();
    }

    @Bean
    @ConditionalOnClass(InterceptorConfiguration.class)
    public InterceptorConfiguration interceptorConfiguration() {
        return new InterceptorConfiguration();
    }


}