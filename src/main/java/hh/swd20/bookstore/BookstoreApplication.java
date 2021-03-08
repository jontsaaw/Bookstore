package hh.swd20.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;
@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository) {
	return (args) -> {
		log.info("save some sample categories");
		Category category1 = new Category("Thriller");
		Category category2 = new Category("Romance");
		Category category3 = new Category("History");
		categoryRepository.save(category1);
		categoryRepository.save(category2);
		categoryRepository.save(category3);
		

		
		log.info("fetch all categories");
		for (Category category : categoryRepository.findAll()) {
			log.info(category.toString());
		}
		
		log.info("save a couple of books");
		
		
		Book book1 = new Book("Roihu", "Tuomas Niskakangas", 2021, "9789511378549", 24.95, category1);
		Book book2 = new Book("Lumimyrsky", "Ruth Ware", 2020, "9789511381723", 27.95, category1);
		bookRepository.save(book1);
		bookRepository.save(book2);	
		

		log.info("fetch all books");
		for (Book book : bookRepository.findAll()) {
			log.info(book.toString());
		}
		
		
	};
	}
}
