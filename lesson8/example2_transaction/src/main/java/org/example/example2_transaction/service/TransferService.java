package org.example.example2_transaction.service;

import lombok.AllArgsConstructor;
import org.example.example2_transaction.model.Account;
import org.example.example2_transaction.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Service
public class TransferService {

    private final AccountRepository accountRepository;

    @Transactional
    public void transferMoney(long idSender, long idReceiver, BigDecimal amount) {
        Account sender = accountRepository.findAccountById(idSender);
        Account receiver = accountRepository.findAccountById(idReceiver);

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        accountRepository.changeAmount(idSender, senderNewAmount);
        accountRepository.changeAmount(idReceiver, receiverNewAmount);
        //Часть 2
        throw new RuntimeException("Oh no! Something went wrong!");
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAllAccounts();
    }
}