package com.company.ewallet_spring.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrationResponse {
    Integer walletId;
    Integer customerId;
    Error error;
}
