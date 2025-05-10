package org.brewthejava.ping;

import io.opentelemetry.exporter.otlp.http.trace.OtlpHttpSpanExporter;
import io.opentelemetry.exporter.otlp.trace.OtlpGrpcSpanExporter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TracingConfiguration {
//    @Bean
//    public OtlpHttpSpanExporter otlpHttpSpanExporter(@Value("${tracing.url}") String url) {
//        return OtlpHttpSpanExporter.builder()
//            .setEndpoint(url)
//            .build();
//    }

    @Bean
    public OtlpGrpcSpanExporter otlpGrpcSpanExporter(@Value("${tracing.url}") String url) {
        return OtlpGrpcSpanExporter.builder()
            .setEndpoint(url)
            .build();
    }
}
