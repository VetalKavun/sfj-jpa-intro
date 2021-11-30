package com.example.sfgjpaintro;

import com.example.sfgjpaintro.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles("local")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ComponentScan(basePackages = {"com.example.sfgjpaintro.bootstrap"})
public class PostgreSQLIntegrationTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    void name() {
        long count = bookRepository.count();
        assertThat(count).isEqualTo(2);
    }
}
