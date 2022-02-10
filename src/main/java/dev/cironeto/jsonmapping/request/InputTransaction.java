package dev.cironeto.jsonmapping.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class InputTransaction implements Serializable {

    private String encodedKey;
    private String parentAccountKey;
    private String creationDate;
    private String type;
    private Date valueDate;
    private Double amount;
    private String currencyCode;
    private Double totalBalance;
    private String id;
    private String userKey;

    @JsonProperty("accountBalances")
    private void getTotalBalance(Map<String, Object> accountBalances) {
        this.totalBalance = Double.valueOf(String.valueOf(accountBalances.get("totalBalance")));
    }

}



