package com.company.ewallet_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest {
    Integer amount;
    Instant date;
    String description;
    String ibanFrom;
    String ibanTo;
    String operationCode;
}
