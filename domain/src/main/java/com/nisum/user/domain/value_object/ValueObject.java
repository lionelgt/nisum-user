package com.nisum.user.domain.value_object;

import com.google.common.base.Preconditions;

import lombok.Getter;

@Getter
public abstract class ValueObject<T> {
    private T value;
    
    protected ValueObject(T value) {
        Preconditions.checkArgument(value != null, "it can't be null");
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
