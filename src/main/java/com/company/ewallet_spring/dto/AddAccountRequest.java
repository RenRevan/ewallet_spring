package com.company.ewallet_spring.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddAccountRequest {
    String iban;
    Integer walletId;
    Integer bankId;
    Integer currencyId;
}
