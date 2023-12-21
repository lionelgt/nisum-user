package com.nisum.user.domain.value_object;

import com.google.common.base.Preconditions;

public class Email extends ValueObject<String> {
    private Email(String email) {
        super(email);
    }
    
    public static Email of(String email, String regex){
        Preconditions.checkArgument(email.matches(regex), "email.invalid");
        return new Email(email);
    }
}
