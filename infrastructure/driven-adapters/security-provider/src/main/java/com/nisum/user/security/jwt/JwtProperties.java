package com.nisum.user.security.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Configuration
@NoArgsConstructor
@ConfigurationProperties(prefix = "security.jwt", ignoreInvalidFields = true)
public class JwtProperties {
    private String base64Secret;
    private long tokenValidityInSeconds;
}
