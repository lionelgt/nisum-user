package com.nisum.user.domain.driven_port;

import com.nisum.user.domain.model.TokenDetail;

public interface JwtTokenPort {
    String createToken(TokenDetail tokenDetail);
}
