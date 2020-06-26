package com.project.library.api.bootstrap;

import com.project.library.api.repositories.BookEditionRepository;
import com.project.library.api.repositories.RentalRepository;
import com.project.library.api.repositories.TitleRepository;
import com.project.library.api.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final BookEditionRepository bookEditionRepository;
    private final RentalRepository rentalRepository;
    private final TitleRepository titleRepository;
    private final UserRepository userRepository;

    public DataLoader(
            BookEditionRepository bookEditionRepository,
            RentalRepository rentalRepository,
            TitleRepository titleRepository,
            UserRepository userRepository) {
        this.bookEditionRepository = bookEditionRepository;
        this.rentalRepository = rentalRepository;
        this.titleRepository = titleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
