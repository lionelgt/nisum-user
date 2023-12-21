package com.nisum.user.domain.value_object;

import java.util.UUID;


public class Id extends ValueObject<UUID> {
    private Id(UUID id) {
        super(id);
    }
    
    public static  Id of(UUID uuid){
        return new Id(uuid);
    }
    public static Id make() {
        return new Id(UUID.randomUUID());
    }
}
