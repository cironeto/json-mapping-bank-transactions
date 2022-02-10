package dev.cironeto.jsonmapping.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    void findAllByUserKey() {
        transactionRepository.findAllByUserKey("8a85867e6ad9e761016ada958bdf5b0f");
    }
}