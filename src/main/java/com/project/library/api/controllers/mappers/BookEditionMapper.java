package com.project.library.api.controllers.mappers;

import com.project.library.api.domain.BookEdition;
import com.project.library.api.domain.dto.BookEditionDto;
import com.project.library.api.repositories.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookEditionMapper {

    @Autowired
    TitleRepository titleRepository;

    public BookEdition mapToBookEdition(final BookEditionDto bookEditionDto) {
        return new BookEdition(
                titleRepository.findById(bookEditionDto.getTitleId()).get(),
                bookEditionDto.getBookStatus()
        );
    }

    public BookEditionDto mapToBookEditionDto(final BookEdition bookEdition) {
        return new BookEditionDto(
                bookEdition.getId(),
                bookEdition.getTitle().getId(),
                bookEdition.getBookStatus()
        );
    }

    public List<BookEditionDto> mapToBookEditionDtoList(final List<BookEdition> bookEditionList) {
        return bookEditionList.stream()
                .map(t -> new BookEditionDto(
                        t.getId(),
                        t.getTitle().getId(),
                        t.getBookStatus()))
                .collect(Collectors.toList());
    }
}
