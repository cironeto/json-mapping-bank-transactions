package dev.cironeto.jsonmapping.service;

import dev.cironeto.jsonmapping.domain.AppUser;
import dev.cironeto.jsonmapping.domain.Transaction;
import dev.cironeto.jsonmapping.repository.AppUserRepository;
import dev.cironeto.jsonmapping.repository.TransactionRepository;
import dev.cironeto.jsonmapping.service.exception.ForbiddenException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final AppUserRepository appUserRepository;
    private final AuthService authService;

    public List<Transaction> saveTransactions(List<Transaction> transactions) {
        return transactionRepository.saveAll(transactions);
    }

    public List<Transaction> listTransactionByAccountId(Long id) throws Exception {
        if(!Objects.equals(authService.getAuthenticatedUser().getId(), id)){
            throw new ForbiddenException("Access denied. Invalid user for this transaction");
        }
        AppUser appUser = appUserRepository.getById(id);
        return transactionRepository.findAllByUserKey(appUser.getUserKey());
    }

}
