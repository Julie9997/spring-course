package ru.julie.spring_data_example.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.julie.spring_data_example.dto.TransferRequest;
import ru.julie.spring_data_example.model.Account;
import ru.julie.spring_data_example.services.TransferService;

@AllArgsConstructor
@RestController
public class AccountController {

    private final TransferService transferService;


    @PostMapping("/transfer")
    public void transferMoney(
            @RequestBody TransferRequest request
    ) {
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