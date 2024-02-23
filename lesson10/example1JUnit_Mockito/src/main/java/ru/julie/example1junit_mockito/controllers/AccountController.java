package ru.julie.example1junit_mockito.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.julie.example1junit_mockito.dto.TransferRequest;
import ru.julie.example1junit_mockito.model.Account;
import ru.julie.example1junit_mockito.service.TransferService;

import javax.security.auth.login.AccountNotFoundException;

@AllArgsConstructor
@RestController
public class AccountController {

    private final TransferService transferService;



    @PostMapping("/transfer")
    public void transferMoney(
            @RequestBody TransferRequest request
    ) throws AccountNotFoundException {
        transferService.transferMoney(
                request.getSenderAccountId(),
                request.getReceiverAccountId(),
                request.getAmount());
    }

    @GetMapping("/accounts")
    public Iterable<Account> getAllAccounts(
            @RequestParam(required = false) String name
    ) {
        if (name == null) {
            return transferService.getAllAccounts();
        } else {
            return transferService.findAccountsByName(name);
        }
    }

}
