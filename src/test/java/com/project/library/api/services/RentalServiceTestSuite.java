package com.project.library.api.services;

import com.project.library.api.domain.*;
import com.project.library.api.repositories.BookEditionRepository;
import com.project.library.api.repositories.RentalRepository;
import com.project.library.api.repositories.TitleRepository;
import com.project.library.api.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RentalServiceTestSuite {

    @Autowired
    RentalRepository rentalRepository;

    @Autowired
    RentalServiceImpl rentalService;

    @Autowired
    TitleRepository titleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookEditionRepository bookEditionRepository;

    @Test
    public void testGetAllRentals() {
        //Given
        User user1 = new User("John", "Snow", LocalDate.of(2010, 4, 5));
        userRepository.save(user1);
        Title title1 = new Title("Catch 22", "J.Haller", 1968);
        Title title2 = new Title("Memories", "J.Hiragami", 2010);
        titleRepository.save(title1);
        titleRepository.save(title2);
        BookEdition bookEdition1 = new BookEdition(title1, BookStatus.AVAILABLE);
        BookEdition bookEdition2 = new BookEdition(title2, BookStatus.AVAILABLE);
        bookEditionRepository.save(bookEdition1);
        bookEditionRepository.save(bookEdition2);
        Rental rental1 = new Rental(bookEdition1, user1, LocalDate.of(2020, 10, 23), LocalDate.of(2020, 11, 10));
        Rental rental2 = new Rental(bookEdition2, user1, LocalDate.of(2020, 12, 11), LocalDate.of(2021, 1, 26));
        rentalRepository.save(rental1);
        rentalRepository.save(rental2);

        //When
        List<Rental> rentalList = rentalService.getAllRentals();

        //Then
        Assert.assertEquals(2, rentalList.size());

        //CleanUp
        rentalRepository.deleteAll();
    }

    @Test
    public void testGetRentalById() {
        //Given
        User user1 = new User("John", "Snow", LocalDate.of(2010, 4, 5));
        userRepository.save(user1);
        Title title1 = new Title("Catch 22", "J.Haller", 1968);
        Title title2 = new Title("Memories", "J.Hiragami", 2010);
        titleRepository.save(title1);
        titleRepository.save(title2);
        BookEdition bookEdition1 = new BookEdition(title1, BookStatus.AVAILABLE);
        BookEdition bookEdition2 = new BookEdition(title2, BookStatus.AVAILABLE);
        bookEditionRepository.save(bookEdition1);
        bookEditionRepository.save(bookEdition2);
        Rental rental1 = new Rental(bookEdition1, user1, LocalDate.of(2020, 10, 23), LocalDate.of(2020, 11, 10));
        Rental rental2 = new Rental(bookEdition2, user1, LocalDate.of(2020, 12, 11), LocalDate.of(2021, 1, 26));
        rentalRepository.save(rental1);
        rentalRepository.save(rental2);
        Long rentalId = rental1.getId();

        //When
        Rental testRental = rentalService.getRentalById(rentalId).get();

        //Then
        Assert.assertEquals(LocalDate.of(2020, 10, 23), testRental.getRentalDate());

        //CleanUp
        rentalRepository.deleteAll();
    }

    @Test
    public void testSaveRental() {
        //Given
        User user1 = new User("John", "Snow", LocalDate.of(2010, 4, 5));
        userRepository.save(user1);
        Title title1 = new Title("Catch 22", "J.Haller", 1968);
        Title title2 = new Title("Memories", "J.Hiragami", 2010);
        titleRepository.save(title1);
        titleRepository.save(title2);
        BookEdition bookEdition1 = new BookEdition(title1, BookStatus.AVAILABLE);
        BookEdition bookEdition2 = new BookEdition(title2, BookStatus.AVAILABLE);
        bookEditionRepository.save(bookEdition1);
        bookEditionRepository.save(bookEdition2);
        Rental rental1 = new Rental(bookEdition1, user1, LocalDate.of(2020, 10, 23), LocalDate.of(2020, 11, 10));
        Rental rental2 = new Rental(bookEdition2, user1, LocalDate.of(2020, 12, 11), LocalDate.of(2021, 1, 26));

        //When
        rentalService.saveRental(rental1);
        rentalService.saveRental(rental2);

        //Then
        Assert.assertEquals(2, rentalService.getAllRentals().size());

        //CleanUp
        rentalRepository.deleteAll();
    }

    @Test
    public void testDeleteRentalById() {
        //Given
        User user1 = new User("John", "Snow", LocalDate.of(2010, 4, 5));
        userRepository.save(user1);
        Title title1 = new Title("Catch 22", "J.Haller", 1968);
        Title title2 = new Title("Memories", "J.Hiragami", 2010);
        titleRepository.save(title1);
        titleRepository.save(title2);
        BookEdition bookEdition1 = new BookEdition(title1, BookStatus.AVAILABLE);
        BookEdition bookEdition2 = new BookEdition(title2, BookStatus.AVAILABLE);
        bookEditionRepository.save(bookEdition1);
        bookEditionRepository.save(bookEdition2);
        Rental rental1 = new Rental(bookEdition1, user1, LocalDate.of(2020, 10, 23), LocalDate.of(2020, 11, 10));
        Rental rental2 = new Rental(bookEdition2, user1, LocalDate.of(2020, 12, 11), LocalDate.of(2021, 1, 26));
        rentalRepository.save(rental1);
        rentalRepository.save(rental2);
        Long rentalId = rental1.getId();

        //When
        rentalService.deleteRentalById(rentalId);

        //Then
        Assert.assertEquals(1, rentalService.getAllRentals().size());

        //CleanUp
        rentalRepository.deleteAll();
    }
}
