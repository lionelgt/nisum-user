package com.nisum.user.security.jwt;

import com.nisum.user.domain.exception.UserException;
import com.nisum.user.domain.model.TokenDetail;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
    private static final String AUTHORITIES_KEY = "auth";
    private static final String USER_DETAILS = "details";
    private static final ConcurrentHashMap<String, Key> keyCache = new ConcurrentHashMap<>();
    
    private final JwtProperties jwtProperties;

    public String makeToken(TokenDetail tokenDetail) {
        Key key = keyCache.computeIfAbsent(jwtProperties.getBase64Secret(), k -> Keys.hmacShaKeyFor(Decoders.BASE64.decode(k)));
        String authorities = tokenDetail.getRoles().stream().collect(Collectors.joining(","));
        
        long now = (new Date()).getTime();
        Date validity = new Date(now + jwtProperties.getTokenValidityInSeconds());

        return Jwts.builder()
                .setSubject(tokenDetail.getName())
                .claim(AUTHORITIES_KEY, authorities)
                .claim(USER_DETAILS, tokenDetail.getDetails())
                .signWith(key, SignatureAlgorithm.HS512)
                .setExpiration(validity)
                .compact();
    }

    public TokenDetail getTokenDetail(String token, String base64Secret) {
        Key key = keyCache.computeIfAbsent(base64Secret, k -> Keys.hmacShaKeyFor(Decoders.BASE64.decode(k)));
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key).build()
                .parseClaimsJws(token)
                .getBody();

        List<String> authorities = Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                        .toList();

        HashMap<String, String> details =  claims.get(USER_DETAILS, HashMap.class);

        return TokenDetail.builder()
                          .id(details.get(TokenDetail.ID))
                          .name(claims.getSubject())
                          .email(details.get(TokenDetail.EMAIL))
                          .roles(authorities).build();
    }

    public boolean validateToken(String authToken, String base64Secret) {
        try {
            Key key = keyCache.computeIfAbsent(base64Secret, k -> Keys.hmacShaKeyFor(Decoders.BASE64.decode(k)));
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(authToken);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            log.error("Invalid JWT token trace.", e);
            throw new UserException("SessionExpired", HttpStatus.UNAUTHORIZED.value());
        }
    }

    public Jws<Claims> parseClaims(String authToken, String base64Secret) {
        try {
            Key key = keyCache.computeIfAbsent(base64Secret, k -> Keys.hmacShaKeyFor(Decoders.BASE64.decode(k)));
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(authToken);
        } catch (JwtException | IllegalArgumentException e) {
            log.error("Invalid JWT token trace.", e);
            throw new UserException("SessionExpired", HttpStatus.UNAUTHORIZED.value());
        }
    }
}
