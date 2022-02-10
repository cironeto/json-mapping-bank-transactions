package dev.cironeto.jsonmapping.repository;

import dev.cironeto.jsonmapping.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

    List<Transaction> findAllByUserKey(String id);
}
