package dev.cironeto.jsonmapping.controller;

import dev.cironeto.jsonmapping.dto.TransactionDto;
import dev.cironeto.jsonmapping.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<TransactionDto>> findAll() {
        return ResponseEntity.ok(transactionService.findAll());
    }
}
