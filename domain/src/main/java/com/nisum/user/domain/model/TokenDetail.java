package com.nisum.user.domain.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
public class TokenDetail {
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    
    private final String id;
    private final String email;
    private final String name;
    private HashMap<String, String> details;
    private List<String> roles =  Collections.emptyList();

    @Builder
    public static TokenDetail makeTokenDetail(String id, String email, String name, List<String> roles) {
        TokenDetail tokenDetail = new TokenDetail(id, email, name);
        HashMap<String, String> details = new HashMap();
        details.put(ID, id);
        details.put(EMAIL, email);
        details.put(NAME, name);
        tokenDetail.setDetails(details);
        if (roles != null)
            tokenDetail.setRoles(roles);
        return tokenDetail;
    }
}
