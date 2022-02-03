package dev.cironeto.jsonmapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.cironeto.jsonmapping.entity.InputTransaction;
import dev.cironeto.jsonmapping.entity.Transaction;
import dev.cironeto.jsonmapping.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class ConvertJsonApplication implements CommandLineRunner {
    private final TransactionRepository transactionRepository;

    public static void main(String[] args)  {
        SpringApplication.run(ConvertJsonApplication.class, args);
    }

    @Override
    public void run(String... args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        List<InputTransaction> transactions = Arrays.asList(mapper.readValue(Paths.get("transactions.json")
                .toFile(), InputTransaction[].class));

        transactions.forEach(it -> log.info(it.toString()));
        log.info("mapping");


//        transactionRepository.save();

    }
}
