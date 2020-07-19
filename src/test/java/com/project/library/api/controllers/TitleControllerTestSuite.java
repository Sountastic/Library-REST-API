package com.project.library.api.controllers;

import com.project.library.api.controllers.mappers.TitleMapper;
import com.project.library.api.domain.Title;
import com.project.library.api.domain.dto.TitleDto;
import com.project.library.api.services.TitleServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(TitleController.class)
public class TitleControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TitleServiceImpl titleServiceMock;

    @MockBean
    private TitleMapper titleMapperMock;

    @Test
    public void getAllTitlesShouldReturnFoundTitleEntries() throws Exception {
        //Given
        Title title1 = new Title("Catch 22", "J.Haller", 1968);
        Title title2 = new Title("Shining", "S.King", 1975);
        //When
        when(titleServiceMock.getAllTitles()).thenReturn(Arrays.asList(title1, title2));
        TitleDto title1Dto = new TitleDto(1L, "Catch 22", "J.Haller", 1968);
        TitleDto title2Dto = new TitleDto(2L, "Shining", "S.King", 1975);
        when(titleMapperMock.mapToTitleDtoList(any())).thenReturn(Arrays.asList(title1Dto, title2Dto));
        mockMvc.perform(get("/v1/title/titles"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].title", is("Catch 22")))
                .andExpect(jsonPath("$[0]author", is("J.Haller")))
                .andExpect(jsonPath("$[0]releaseYear", is(1968)))
                .andExpect(jsonPath("$[1].title", is("Shining")))
                .andExpect(jsonPath("$[1]author", is("S.King")))
                .andExpect(jsonPath("$[1]releaseYear", is(1975)));
        //Then
        verify(titleServiceMock, times(1)).getAllTitles();
        verifyNoMoreInteractions(titleServiceMock);
    }

    @Test
    public void getTitleById() throws Exception {
        //Given
        Title title1 = new Title("Catch 22", "J.Haller", 1968);
        //When
        when(titleServiceMock.getTitleById(1L)).thenReturn(java.util.Optional.of(title1));
        TitleDto title1Dto = new TitleDto(1L, "Catch 22", "J.Haller", 1968);
        when(titleMapperMock.mapToTitleDto(any())).thenReturn(title1Dto);
        mockMvc.perform(get("/v1/title/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("Catch 22")))
                .andExpect(jsonPath("$.author", is("J.Haller")))
                .andExpect(jsonPath("$.releaseYear", is(1968)));
        //Then
        verify(titleServiceMock, times(1)).getTitleById(1L);
        verifyNoMoreInteractions(titleServiceMock);
    }
}