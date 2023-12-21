package com.nisum.user.api.dto;

import lombok.Data;

@Data
public class PhoneResponse {
    private String id;
    private String number;
    private String cityCode;
    private String countryCode;
}
