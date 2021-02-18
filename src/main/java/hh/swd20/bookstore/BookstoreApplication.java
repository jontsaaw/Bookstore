package hh.swd20.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(BookRepository bookRepository) {
	return (args) -> {
		log.info("save a couple of books");
		Book book1 = new Book("Roihu", "Tuomas Niskakangas", 2021, "9789511378549", 24.95);
		Book book2 = new Book("Lumimyrsky", "Ruth Ware", 2020, "9789511381723", 27.95);
		bookRepository.save(book1);
		bookRepository.save(book2);	
		
		log.info("fetch all books");
		for (Book book : bookRepository.findAll()) {
			log.info(book.toString());
		}
	};
	}
}
