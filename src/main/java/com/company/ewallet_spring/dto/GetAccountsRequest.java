package com.company.ewallet_spring.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAccountsRequest {
    String customerEmail;
}
