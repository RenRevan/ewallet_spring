package com.company.ewallet_spring.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AddAccountResponse {

    AccountItem accountItems;
    Error error;
}
