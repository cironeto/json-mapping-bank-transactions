package dev.cironeto.jsonmapping.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.cironeto.jsonmapping.entity.Transaction;
import dev.cironeto.jsonmapping.enums.CreditDebitIndicator;
import lombok.*;

import java.io.Serializable;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionDto implements Serializable {

    private String id;
    private String arrangementId;
    private String bookingDate;
    private String type;
    private Date valueDate;
    private Double amount;
    private String currencyCode;
    private String currency;
    private CreditDebitIndicator creditDebitIndicator;
    private Double runningBalance;
    private String counterPartyAccountNumber;
    private String reference;
    private String typeGroup;
    private Double instructedAmount;
    @JsonIgnore
    private String userKey;


    public TransactionDto(Transaction entity) {
        id = entity.getId();
        arrangementId = entity.getArrangementId();
        bookingDate = entity.getBookingDate();
        type = entity.getType();
        valueDate = entity.getValueDate();
        amount = entity.getAmount();
        currencyCode = entity.getCurrencyCode();
        currency = entity.getCurrency();
        creditDebitIndicator = entity.getCreditDebitIndicator();
        runningBalance = entity.getRunningBalance();
        counterPartyAccountNumber = entity.getCounterPartyAccountNumber();
        reference = entity.getReference();
        typeGroup = entity.getTypeGroup();
        instructedAmount = entity.getInstructedAmount();
        userKey = entity.getUserKey();
    }

    public TransactionDto(InputTransaction inputTransaction) {
        id = inputTransaction.getEncodedKey();
        arrangementId = inputTransaction.getParentAccountKey();
        bookingDate = inputTransaction.getCreationDate();
        type = inputTransaction.getType();
        valueDate = inputTransaction.getValueDate();
        amount = inputTransaction.getAmount();
        currencyCode = inputTransaction.getCurrencyCode();
        currency = inputTransaction.getCurrencyCode();
        creditDebitIndicator = inputTransaction.getAmount() >= 0 ? CreditDebitIndicator.CREDIT : CreditDebitIndicator.DEBIT;
        runningBalance = inputTransaction.getTotalBalance();
        counterPartyAccountNumber = inputTransaction.getId();
        reference = inputTransaction.getParentAccountKey();
        typeGroup = inputTransaction.getType();
        instructedAmount = inputTransaction.getAmount();
        userKey = inputTransaction.getUserKey();
    }

}



