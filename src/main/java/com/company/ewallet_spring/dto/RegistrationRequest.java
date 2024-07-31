package com.company.ewallet_spring.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrationRequest {
    String mobileNumber;
    String email;
    String firstName;
    String lastName;
    String password;
}
