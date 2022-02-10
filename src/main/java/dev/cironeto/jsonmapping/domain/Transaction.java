package dev.cironeto.jsonmapping.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.cironeto.jsonmapping.request.InputTransaction;
import dev.cironeto.jsonmapping.enums.CreditDebitIndicator;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Table(name = "tb_transaction")
public class Transaction implements Serializable {

    @Id
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

    public Transaction(InputTransaction inputTransaction) {
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
