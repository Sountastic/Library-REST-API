package com.project.library.api.services;

import com.project.library.api.domain.Title;
import com.project.library.api.repositories.TitleRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TitleServiceTestSuite {

    @Autowired
    TitleRepository titleRepository;

    @Autowired
    TitleServiceImpl titleService;

    @Test
    public void testGetAllTitles() {
        //Given
        Title title1 = new Title("Catch 22", "J.Haller", 1968);
        Title title2 = new Title("Shining", "S.King", 1975);
        titleRepository.save(title1);
        titleRepository.save(title2);
        //When
        List<Title> titleList = titleService.getAllTitles();
        //Then
        Assert.assertEquals(2, titleList.size());
        //CleanUp
        titleRepository.deleteAll();
    }

    @Test
    public void testGetTitleById() {
        //Given
        Title title1 = new Title("Catch 22", "J.Haller", 1968);
        Title title2 = new Title("Shining", "S.King", 1975);
        titleRepository.save(title1);
        titleRepository.save(title2);
        Long titleId = title2.getId();
        //When
        Title testTitle = titleService.getTitleById(titleId).get();
        //Then
        Assert.assertEquals("Shining", testTitle.getTitle());
        //CleanUp
        titleRepository.deleteAll();
    }

    @Test
    public void testSaveTitle() {
        //Given
        Title title1 = new Title("Catch 22", "J.Haller", 1968);
        Title title2 = new Title("Shining", "S.King", 1975);
        //When
        titleService.saveTitle(title1);
        titleService.saveTitle(title2);
        //Then
        Assert.assertEquals(2, titleService.getAllTitles().size());
        //CleanUp
        titleRepository.deleteAll();
    }

    @Test
    public void testDeleteTitleById() {
        //Given
        Title title1 = new Title("Catch 22", "J.Haller", 1968);
        Title title2 = new Title("Shining", "S.King", 1975);
        titleRepository.save(title1);
        titleRepository.save(title2);
        Long titleId = title1.getId();
        //When
        titleService.deleteTitleById(titleId);
        //Then
        Assert.assertEquals(1, titleService.getAllTitles().size());
        //CleanUp
        titleRepository.deleteAll();
    }
}