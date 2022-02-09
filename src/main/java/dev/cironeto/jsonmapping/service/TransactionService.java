package dev.cironeto.jsonmapping.service;

import dev.cironeto.jsonmapping.dto.TransactionDto;
import dev.cironeto.jsonmapping.domain.Transaction;
import dev.cironeto.jsonmapping.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;

    @Transactional
    public TransactionDto save(TransactionDto dto) {
        Transaction entity = new Transaction();
        convertDtoToEntity(entity, dto);
        entity = transactionRepository.save(entity);
        return new TransactionDto(entity);
    }

    @Transactional(readOnly = true)
    public List<TransactionDto> findAll() {
        List<Transaction> list = transactionRepository.findAll();

        List<TransactionDto> dtoList = new ArrayList<>();

        for (Transaction transaction : list) {
            TransactionDto dto = new TransactionDto(transaction);
            dtoList.add(dto);
        }
        return dtoList;
    }


    private void convertDtoToEntity(Transaction entity, TransactionDto dto) {
        entity.setId(dto.getId());
        entity.setArrangementId(dto.getArrangementId());
        entity.setBookingDate(dto.getBookingDate());
        entity.setType(dto.getType());
        entity.setValueDate(dto.getValueDate());
        entity.setAmount(dto.getAmount());
        entity.setCurrencyCode(dto.getCurrencyCode());
        entity.setCurrency(dto.getCurrency());
        entity.setCreditDebitIndicator(dto.getCreditDebitIndicator());
        entity.setRunningBalance(dto.getRunningBalance());
        entity.setCounterPartyAccountNumber(dto.getCounterPartyAccountNumber());
        entity.setReference(dto.getReference());
        entity.setTypeGroup(dto.getTypeGroup());
        entity.setInstructedAmount(dto.getInstructedAmount());
        entity.setUserKey(dto.getUserKey());


    }
}
