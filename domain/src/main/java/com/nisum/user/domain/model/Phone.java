package com.nisum.user.domain.model;

import com.nisum.user.domain.value_object.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Phone {
    private Id id;
    private Id userId;
    private String number;
    private String cityCode;
    private String countryCode;
}
