package com.company.ewallet_spring.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountItem {
    String iban;

    Integer balance;

    String bankName;

    String bankMfo;

    String currencyCode;
}
