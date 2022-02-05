package dev.cironeto.jsonmapping.entity;

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
    private String userKey;

}
