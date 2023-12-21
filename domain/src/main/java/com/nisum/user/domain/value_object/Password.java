package com.nisum.user.domain.value_object;

import com.google.common.base.Preconditions;

public class Password extends ValueObject<String> {
    private Password(String password) {
        super(password);
    }
    public static Password of(String password, String regex){
        Preconditions.checkArgument(password.matches(regex), "password.invalid");
        return new Password(password);
    }
}
