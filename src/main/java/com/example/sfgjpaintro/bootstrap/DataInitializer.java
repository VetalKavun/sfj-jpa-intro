package com.example.sfgjpaintro.bootstrap;

import com.example.sfgjpaintro.domain.Book;
import com.example.sfgjpaintro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"local", "default"})
@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();
        Book bookDDD = new Book("Domain Driven Design", "123", "SomePublisher");
        Book bookSIA = new Book("Spring In Acition", "2352", "AnotherPublisher");

        System.out.println("bookDDD Id: " + bookDDD.getId());
        System.out.println("bookSIA Id: " + bookSIA.getId());

        bookDDD = bookRepository.save(bookDDD);
        bookSIA = bookRepository.save(bookSIA);

        System.out.println("bookDDD Id: " + bookDDD.getId());
        System.out.println("bookSIA Id: " + bookSIA.getId());

        bookRepository.findAll().forEach(book -> {
            System.out.println("Book Id: " + book.getId());
            System.out.println("Book title: " + book.getTitle());
        });

    }
}
