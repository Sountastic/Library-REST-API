package com.project.library.api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TitleDto {
    private Long id;
    private String title;
    private String author;
    private Integer releaseYear;
}
