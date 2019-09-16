package com.lhq.cloud.core.autoconfigure;

import com.lhq.cloud.core.log.TraceLogUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;

public class UtilConfiguration {

    @Bean
    @ConditionalOnClass(TraceLogUtils.class)
    public TraceLogUtils traceLogUtils() {
        return new TraceLogUtils();
    }
}