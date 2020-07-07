package com.project.library.api.services;

import com.project.library.api.domain.BookEdition;
import com.project.library.api.domain.BookStatus;
import com.project.library.api.domain.Title;
import com.project.library.api.repositories.BookEditionRepository;
import com.project.library.api.repositories.TitleRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookEditionServiceTestSuite {

    @Autowired
    BookEditionRepository bookEditionRepository;

    @Autowired
    BookEditionServiceImpl bookEditionService;

    @Autowired
    TitleRepository titleRepository;

//    Title title1;
//    Title title2;
//
//    @Before
//    public void init() {
//        title1 = new Title("Catch 22", "J.Haller", 1968);
//        title2 = new Title("Shining", "S.King", 1975);
//    }

    @Test
    public void testGetAllEditions() {
        //Given
        Title title1 = new Title("Catch 22", "J.Haller", 1968);
        Title title2 = new Title("Shining", "S.King", 1975);
        titleRepository.saveAndFlush(title1);
        titleRepository.saveAndFlush(title2);
        BookEdition book1 = new BookEdition(title1, BookStatus.AVAILABLE);
        BookEdition book2 = new BookEdition(title2, BookStatus.AVAILABLE);
        BookEdition book3 = new BookEdition(title2, BookStatus.BORROWED);
        bookEditionRepository.save(book1);
        bookEditionRepository.save(book2);
        bookEditionRepository.save(book3);
        //When
        List<BookEdition> booksList = bookEditionService.getAllEditions();
        //Then
        Assert.assertEquals(3, booksList.size());
        //CleanUp
        bookEditionRepository.deleteAll();
    }

    @Test
    public void testGetEditionById() {
        //Given
        Title title1 = new Title("Catch 22", "J.Haller", 1968);
        Title title2 = new Title("Shining", "S.King", 1975);
        titleRepository.saveAndFlush(title1);
        titleRepository.saveAndFlush(title2);
        BookEdition book1 = new BookEdition(title1, BookStatus.AVAILABLE);
        BookEdition book2 = new BookEdition(title2, BookStatus.AVAILABLE);
        BookEdition book3 = new BookEdition(title2, BookStatus.BORROWED);
        bookEditionRepository.save(book1);
        bookEditionRepository.save(book2);
        bookEditionRepository.save(book3);
        Long editionId = book1.getId();
        //When
        BookEdition testBook = bookEditionService.getEditionById(editionId).get();
        //Then
        Assert.assertEquals(BookStatus.AVAILABLE, testBook.getBookStatus());
        //CleanUp
        bookEditionRepository.deleteAll();
    }

    @Test
    public void testSaveEdition() {
        //Given
        Title title1 = new Title("Catch 22", "J.Haller", 1968);
        Title title2 = new Title("Shining", "S.King", 1975);
        titleRepository.saveAndFlush(title1);
        titleRepository.saveAndFlush(title2);
        BookEdition book1 = new BookEdition(title1, BookStatus.AVAILABLE);
        BookEdition book2 = new BookEdition(title2, BookStatus.AVAILABLE);
        BookEdition book3 = new BookEdition(title2, BookStatus.BORROWED);
        //When
        bookEditionService.saveEdition(book1);
        bookEditionService.saveEdition(book2);
        bookEditionService.saveEdition(book3);
        //Then
        Assert.assertEquals(3, bookEditionService.getAllEditions().size());
        //CleanUp
        bookEditionRepository.deleteAll();
    }

    @Test
    public void testDeleteEditionById() {
        //Given
        Title title1 = new Title("Catch 22", "J.Haller", 1968);
        Title title2 = new Title("Shining", "S.King", 1975);
        titleRepository.saveAndFlush(title1);
        titleRepository.saveAndFlush(title2);
        BookEdition book1 = new BookEdition(title1, BookStatus.AVAILABLE);
        BookEdition book2 = new BookEdition(title2, BookStatus.AVAILABLE);
        BookEdition book3 = new BookEdition(title2, BookStatus.BORROWED);

        bookEditionRepository.save(book1);
        bookEditionRepository.save(book2);
        bookEditionRepository.save(book3);
        Long editionId = book1.getId();
        //When
        bookEditionService.deleteEditionById(editionId);
        //Then
        Assert.assertEquals(2, bookEditionService.getAllEditions().size());
        //CleanUp
        bookEditionRepository.deleteAll();
    }
}
