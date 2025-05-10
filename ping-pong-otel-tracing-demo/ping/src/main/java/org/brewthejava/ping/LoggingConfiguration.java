package org.brewthejava.ping;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import jakarta.annotation.PostConstruct;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
@ConditionalOnClass(Logger.class)
public class LoggingConfiguration {

    @PostConstruct
    public void setAppender() {
        SpanLogsAppender appender = new SpanLogsAppender();
        appender.start();
        Logger rootLogger = getRootLogger();
        rootLogger.addAppender(appender);
    }

    private Logger getRootLogger() {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        return context.getLogger(Logger.ROOT_LOGGER_NAME);
    }

    @Bean
    public CommonsRequestLoggingFilter requestLoggingFilter() {
        CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
        loggingFilter.setIncludePayload(true);
        loggingFilter.setIncludeHeaders(true);
        loggingFilter.setIncludeClientInfo(true);
        loggingFilter.setIncludeQueryString(true);
        loggingFilter.setMaxPayloadLength(50000);
        loggingFilter.setAfterMessagePrefix("REQUEST DATA: ");
        loggingFilter.setHeaderPredicate(header -> !header.startsWith("Authorization"));
        return loggingFilter;
    }
}
