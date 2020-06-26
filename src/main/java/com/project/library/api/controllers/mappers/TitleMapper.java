package com.project.library.api.controllers.mappers;

import com.project.library.api.domain.Title;
import com.project.library.api.domain.dto.TitleDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TitleMapper {

    public Title mapToTitle(final TitleDto titleDto) {
        return new Title(
                titleDto.getTitle(),
                titleDto.getAuthor(),
                titleDto.getReleaseYear()
        );
    }

    public TitleDto mapToTitleDto(final Title title) {
        return new TitleDto(
                title.getId(),
                title.getTitle(),
                title.getAuthor(),
                title.getReleaseYear()
        );
    }

    public List<TitleDto> mapToTitleDtoList(final List<Title> titleList) {
        return titleList.stream()
                .map(t -> new TitleDto(
                        t.getId(),
                        t.getTitle(),
                        t.getAuthor(),
                        t.getReleaseYear()))
                .collect(Collectors.toList());
    }
}
