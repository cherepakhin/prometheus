package ru.perm.v.prometheus.config;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricConfig {

    @Bean
    Counter counterEcho(MeterRegistry meterRegistry) {
        return Counter
                .builder("echonullcounter")
                .description("counter null echo-request")
                .register(meterRegistry);
    }

}
