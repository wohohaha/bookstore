package com.example.bookstore;


import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.User;
import com.example.bookstore.domain.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BookstoreApplication {

    private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}


	@Bean
    public CommandLineRunner book(BookRepository repository, UserRepository urepository) {
	    return (args) -> {
	        log.info("Adding books to the booklist");
	        repository.save(new Book("C# for dummies", "Jere Hurmekoski", 2017, "123456789-1234", 99.95));
            repository.save(new Book("Parhaat palat lätkästä", "Antero Järviranta", 2013, "12345-54321", 17.69));
            repository.save(new Book("Juttu luistaa kuin sukseni Lake Placidissa 1980", "Juha Mieto", 1981, "10111980-1981", 19.81));

            User user1 = new User("user",
                    "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
            User user2 = new User("admin",
                    "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
            User user3 = new User("jepe",
                    "$2a$10$U8vy9oXGphGP.7.Zpomgoup0ZCeOQHQ7ovGVv7hhjzoNuUl9Egcsi", "ADMIN");
            urepository.save(user1);
            urepository.save(user2);
            urepository.save(user3);


            log.info("retrieving the booklist");
	        for (Book book : repository.findAll()){
	                log.info(book.toString());
            }
            log.info("");
	    };

    }

}
