package com.company.ewallet_spring.presentation;

import com.company.ewallet_spring.dto.*;
import com.company.ewallet_spring.persistence.entities.Customer;
import com.company.ewallet_spring.service.AuthService;
import com.company.ewallet_spring.service.DashboardService;
import com.company.ewallet_spring.service.TransactionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.company.ewallet_spring.Constants.*;

@Slf4j
@RestController
@RequestMapping(WALLET)
@AllArgsConstructor
public class MainController {
    private final AuthService authService;
    private final TransactionService transactionService;
    private final DashboardService dashboardService;

    //todo: replace
    @GetMapping("/allUsers")
    public ResponseEntity<List<Customer>> allCategories() {
        return new ResponseEntity<>(authService.allCustomers(), HttpStatusCode.valueOf(200));
    }
    @GetMapping(GET_ACCOUNTS)
    public GetAccountsResponse allCustomersAccounts(@RequestBody GetAccountsRequest request) {
        return dashboardService.getAccounts(request);
    }

    @PostMapping(ADD_ACCOUNT)
    public AddAccountResponse addAccount(@RequestBody AddAccountRequest request) {
        return dashboardService.addAccountToWallet(request);
    }
    @GetMapping(GET_BENEFICIARY)
    public GetBeneficiaryResponse allCustomersBeneficiary(@RequestBody GetBeneficiaryRequest request) {
        return dashboardService.getBeneficiary(request);
    }

    @PostMapping(ADD_BENEFICIARY)
    public AddBeneficiaryResponse addBeneficiary(@RequestBody AddBeneficiaryRequest request) {
        return dashboardService.addBeneficiary(request);
    }

    @PostMapping(ADD_TRANSACTION)
    public String createTransaction(@RequestBody TransactionRequest request) {
        log.error("[] Received TransactionRequest: {}", request);
        return "ok";
    }

    @PostMapping(REGISTRATION)
    public RegistrationResponse register(@RequestBody RegistrationRequest request) {
        log.error("[] Received RegistrationRequest: {}", request);
        return authService.registration(request);
    }

}
