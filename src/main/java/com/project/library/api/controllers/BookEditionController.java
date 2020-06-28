package com.project.library.api.controllers;

import com.project.library.api.controllers.mappers.BookEditionMapper;
import com.project.library.api.domain.dto.BookEditionDto;
import com.project.library.api.exceptions.BookEditionNotFoundException;
import com.project.library.api.services.BookEditionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/bookedition")
public class BookEditionController {

    private final BookEditionServiceImpl bookEditionService;
    private final BookEditionMapper bookEditionMapper;

    @GetMapping("/editions")
    @ResponseBody
    public List<BookEditionDto> getEditions() {
        return bookEditionMapper.mapToBookEditionDtoList(bookEditionService.getAllEditions());
    }

    @GetMapping("/{editionId}")
    @ResponseBody
    public BookEditionDto getEdition(@PathVariable("editionId") Long editionId) throws BookEditionNotFoundException {
        return bookEditionMapper.mapToBookEditionDto(bookEditionService.getEditionById(editionId).orElseThrow(BookEditionNotFoundException::new));
    }

    @DeleteMapping("/editionId")
    public void deleteEdition(@PathVariable("editionId") Long editionId) {
        bookEditionService.deleteEditionById(editionId);
    }

    @PutMapping("")
    public BookEditionDto updateEdition(@RequestBody BookEditionDto bookEditionDto) {
        return bookEditionMapper.mapToBookEditionDto(bookEditionService.saveEdition(bookEditionMapper.mapToBookEdition(bookEditionDto)));
    }

    @PostMapping("")
    @ResponseBody
    public void createEdition(@RequestBody BookEditionDto bookEditionDto) {
        bookEditionService.saveEdition(bookEditionMapper.mapToBookEdition(bookEditionDto));
    }

}
