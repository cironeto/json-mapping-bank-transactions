package dev.cironeto.jsonmapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.cironeto.jsonmapping.dto.TransactionDto;
import dev.cironeto.jsonmapping.dto.InputTransaction;
import dev.cironeto.jsonmapping.repository.AppUserRepository;
import dev.cironeto.jsonmapping.service.AppUserService;
import dev.cironeto.jsonmapping.service.TransactionService;
import dev.cironeto.jsonmapping.util.AddRoleToUserFactory;
import dev.cironeto.jsonmapping.util.AppUserFactory;
import dev.cironeto.jsonmapping.util.RoleFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class ConvertJsonApplication implements CommandLineRunner {
    private final AppUserRepository appUserRepository;
    private final TransactionService transactionService;
    private final AppUserService appUserService;
    private final AppUserFactory appUserFactory;
    private final RoleFactory roleFactory;


    public static void main(String[] args) {
        SpringApplication.run(ConvertJsonApplication.class, args);
    }


    @Override
    public void run(String... args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        List<InputTransaction> inputTransactionList = Arrays
                .asList(mapper.readValue(Paths.get("transactions.json")
                        .toFile(), InputTransaction[].class));

        List<TransactionDto> dtoList = new ArrayList<>();
        for (InputTransaction inputTransaction : inputTransactionList) {
            TransactionDto transactionDto = new TransactionDto(inputTransaction);
            dtoList.add(transactionDto);
        }

        for (TransactionDto transactionDto : dtoList) {
            transactionService.save(transactionDto);
        }

        roleFactory.createAndPersistRoles();
        appUserFactory.createAndPersistUsersDto();

        appUserService.addRoleToAppUSer("william", "ROLE_ADMIN");
        appUserService.addRoleToAppUSer("david", "ROLE_ADMIN");
        appUserService.addRoleToAppUSer("cironeto", "ROLE_ADMIN");

        log.info("Users and Roles created");
    }
}
