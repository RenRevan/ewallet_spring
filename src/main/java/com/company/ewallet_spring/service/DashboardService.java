package com.company.ewallet_spring.service;

import com.company.ewallet_spring.dto.*;

public interface DashboardService {
    GetBeneficiaryResponse getBeneficiary(GetBeneficiaryRequest request);

    AddBeneficiaryResponse addBeneficiary(AddBeneficiaryRequest request);

    GetAccountsResponse getAccounts(GetAccountsRequest request);

    AddAccountResponse addAccountToWallet(AddAccountRequest request);

}
