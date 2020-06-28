package com.project.library.api.controllers;

import com.project.library.api.controllers.mappers.BookEditionMapper;
import com.project.library.api.domain.dto.BookEditionDto;
import com.project.library.api.services.BookEditionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/bookedition")
public class BookEditionController {

    private final BookEditionServiceImpl bookEditionService;
    private final BookEditionMapper bookEditionMapper;

//    @GetMapping("/editions")
//    @ResponseBody
//    public List<BookEditionDto> getEditions() {
//        return bookEditionMapper.mapToBookEditionDtoList(bookEditionService)
//    }
}
