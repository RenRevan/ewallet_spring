package com.company.ewallet_spring.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class GetAccountsResponse {
    Integer walletId;
    List<AccountItem> accountItems;
    Error error;
}
