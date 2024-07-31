package com.company.ewallet_spring.service.impl;

import com.company.ewallet_spring.dto.*;
import com.company.ewallet_spring.dto.Error;
import com.company.ewallet_spring.persistence.AccountDAO;
import com.company.ewallet_spring.persistence.CustomerDAO;
import com.company.ewallet_spring.persistence.CustomerRoleDAO;
import com.company.ewallet_spring.persistence.WalletDAO;
import com.company.ewallet_spring.persistence.entities.*;
import com.company.ewallet_spring.service.DashboardService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private final CustomerDAO customerDAO;
    private final WalletDAO walletDAO;
    private final AccountDAO accountDAO;

    @Override
    public GetBeneficiaryResponse getBeneficiary(GetBeneficiaryRequest request) {

        return null;
    }

    @Override
    public AddBeneficiaryResponse addBeneficiary(AddBeneficiaryRequest request) {

        return null;
    }

    @Override
    public GetAccountsResponse getAccounts(GetAccountsRequest request) {
        Customer customer = customerDAO.findByEmail(request.getCustomerEmail());
        if (customer == null) {
            return GetAccountsResponse.builder()
                    .error(Error.builder().errorCode("422").errorMessage("Customer not found").build())
                    .build();
        } else {
            Wallet wallet = walletDAO.findByCustomerId(customer.getId());
            List<Account> accountList = accountDAO.findAllByWalletId(wallet.getId());

            List<AccountItem> accountItems = new ArrayList<>();
            for (Account account : accountList) {
                AccountItem accountItem = fromEntityToDtoAccount(account);
                accountItems.add(accountItem);
            }
            return GetAccountsResponse.builder()
                    .walletId(wallet.getId())
                    .accountItems(accountItems)
                    .build();
        }
    }

    @Override
    public AddAccountResponse addAccountToWallet(AddAccountRequest request) {
        Account account = fromDtoToEntityAccount(request);

        if (accountDAO.findAllByIbanAndWalletId(account.getIban(), account.getWallet().getId()).isEmpty()) {
            try {
                accountDAO.create(account);
            } catch (Exception e) {
                return AddAccountResponse.builder()
                        .error(Error.builder()
                                .errorCode("422")
                                .errorMessage("Account data not valid")
                                .build())
                        .build();
            }

            account = accountDAO.findAllByIbanAndWalletId(account.getIban(), account.getWallet().getId()).getFirst();
            AccountItem accountItem = fromEntityToDtoAccount(account);

            log.error("AccountItem = {}", accountItem);
            return AddAccountResponse.builder()
                    .accountItems(accountItem)
                    .build();
        } else {
            return AddAccountResponse.builder()
                    .error(Error.builder()
                            .errorCode("422")
                            .errorMessage("Account already exist in your wallet")
                            .build())
                    .build();
        }
    }

    private AccountItem fromEntityToDtoAccount(Account account) {
        return AccountItem.builder()
                .iban(account.getIban())
                .balance(account.getBalance())
                .bankMfo(account.getBank().getMfo())
                .bankName(account.getBank().getName())
                .currencyCode(account.getCurrency().getCode())
                .build();
    }

    private Account fromDtoToEntityAccount(AddAccountRequest request) {
        return Account.builder()
                .iban(request.getIban())
                .balance(new Random().nextInt())
                .wallet(Wallet.builder().id(request.getWalletId()).build())
                .currency(Currency.builder().id(request.getCurrencyId()).build())
                .bank(Bank.builder().id(request.getBankId()).build())
                .build();
    }
}
