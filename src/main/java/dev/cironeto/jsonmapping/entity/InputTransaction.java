package dev.cironeto.jsonmapping.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;
import java.util.Map;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class InputTransaction {

    private String encodedKey;
    private String parentAccountKey;
    private String creationDate;
    private String type;
    private Date valueDate;
    private Double amount;
    private String currencyCode;
    private Double totalBalance;
    private String id;

    @JsonProperty("accountBalances")
    private void getTotalBalance(Map<String, Object> accountBalances) {
        this.totalBalance = Double.valueOf(String.valueOf(accountBalances.get("totalBalance")));
    }

}



