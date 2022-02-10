package dev.cironeto.jsonmapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.cironeto.jsonmapping.domain.Transaction;
import dev.cironeto.jsonmapping.request.InputTransaction;
import dev.cironeto.jsonmapping.repository.TransactionRepository;
import dev.cironeto.jsonmapping.service.AppUserService;
import dev.cironeto.jsonmapping.service.TransactionService;
import dev.cironeto.jsonmapping.util.AppUserFactory;
import dev.cironeto.jsonmapping.util.RoleFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class ConvertJsonApplication implements CommandLineRunner {
    private final TransactionService transactionService;
    private final TransactionRepository transactionRepository;
    private final AppUserService appUserService;
    private final AppUserFactory appUserFactory;
    private final RoleFactory roleFactory;


    public static void main(String[] args) {
        SpringApplication.run(ConvertJsonApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        List<InputTransaction> inputTransactionList = Arrays
                .asList(mapper.readValue(Paths.get("transactions.json")
                        .toFile(), InputTransaction[].class));

        List<Transaction> transactionList = new ArrayList<>();
        for (InputTransaction inputTransaction : inputTransactionList) {
            Transaction transaction = new Transaction(inputTransaction);
            transactionList.add(transaction);
        }
        transactionService.saveTransactions(transactionList);

        roleFactory.createAndPersistRoles();
        appUserFactory.createAndPersistUsersDto();

        appUserService.addRoleToAppUSer("william", "ROLE_USER");
        appUserService.addRoleToAppUSer("david", "ROLE_USER");
        appUserService.addRoleToAppUSer("ciro", "ROLE_USER");

        log.info("Users and Roles created");

    }

}
