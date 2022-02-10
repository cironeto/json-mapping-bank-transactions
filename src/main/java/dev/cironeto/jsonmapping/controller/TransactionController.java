package dev.cironeto.jsonmapping.controller;

import dev.cironeto.jsonmapping.domain.Transaction;
import dev.cironeto.jsonmapping.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping("/transactions/{id}")
    public ResponseEntity<List<Transaction>> listTransactionByAccountId(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(transactionService.listTransactionByAccountId(id));
    }
}
