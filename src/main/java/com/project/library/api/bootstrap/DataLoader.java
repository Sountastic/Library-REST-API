package com.project.library.api.bootstrap;

import com.project.library.api.domain.*;
import com.project.library.api.repositories.BookEditionRepository;
import com.project.library.api.repositories.RentalRepository;
import com.project.library.api.repositories.TitleRepository;
import com.project.library.api.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.time.LocalDate;

@Component
@ConditionalOnProperty(prefix = "prod.", value = "run")
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
        loadData();
    }

    private void loadData() {
        User user1 = new User("Tom", "Snow", LocalDate.of(2018,3,4));
        User user2 = new User("Justyna", "Wozniak", LocalDate.of(1998, 1, 10));
        userRepository.saveAndFlush(user1);
        userRepository.saveAndFlush(user2);

        Title title1 = new Title("Harry Potter", "J.K.Rownling", 2001);
        Title title2 = new Title("Memories", "J.Hiragami", 2010);
        titleRepository.saveAndFlush(title1);
        titleRepository.saveAndFlush(title2);

        BookEdition bookEdition1 = new BookEdition(title1, BookStatus.AVAILABLE);
        BookEdition bookEdition2 = new BookEdition(title1, BookStatus.AVAILABLE);
        BookEdition bookEdition3 = new BookEdition(title1, BookStatus.BOOKED);
        BookEdition bookEdition4 = new BookEdition(title2, BookStatus.BORROWED);
        BookEdition bookEdition5 = new BookEdition(title2, BookStatus.LOST);
        BookEdition bookEdition6 = new BookEdition(title2, BookStatus.BORROWED);
        bookEditionRepository.saveAndFlush(bookEdition1);
        bookEditionRepository.saveAndFlush(bookEdition2);
        bookEditionRepository.saveAndFlush(bookEdition3);
        bookEditionRepository.saveAndFlush(bookEdition4);
        bookEditionRepository.saveAndFlush(bookEdition5);
        bookEditionRepository.saveAndFlush(bookEdition6);

        Rental rental1 = new Rental(bookEdition4, user1, LocalDate.of(2020, 3, 2), LocalDate.of(2020, 7, 13));
        Rental rental2 = new Rental(bookEdition5, user1, LocalDate.of(2018, 9, 23), LocalDate.of(2019, 1, 11));
        Rental rental3 = new Rental(bookEdition6, user1, LocalDate.of(2019, 11, 30), LocalDate.of(2020, 4, 3));
        rentalRepository.saveAndFlush(rental1);
        rentalRepository.saveAndFlush(rental2);
        rentalRepository.saveAndFlush(rental3);
    }

    @PreDestroy
    public void removeData() {
        bookEditionRepository.deleteAll();
        rentalRepository.deleteAll();
        titleRepository.deleteAll();
        userRepository.deleteAll();
    }
}
