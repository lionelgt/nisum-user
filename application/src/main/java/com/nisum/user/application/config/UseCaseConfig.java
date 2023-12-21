package com.nisum.user.application.config;

import com.nisum.user.domain.annotation.UseCase;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = {"com.nisum.user.domain.*"},
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {UseCase.class})},
        useDefaultFilters = false
)
public class UseCaseConfig {
}
