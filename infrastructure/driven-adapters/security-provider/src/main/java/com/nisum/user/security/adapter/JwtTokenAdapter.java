package com.nisum.user.security.adapter;

import com.nisum.user.domain.driven_port.JwtTokenPort;
import com.nisum.user.domain.model.TokenDetail;
import com.nisum.user.security.jwt.JwtTokenProvider;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtTokenAdapter implements JwtTokenPort {
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public String createToken(TokenDetail tokenDetail) {
        return jwtTokenProvider.makeToken(tokenDetail);
    }
}
