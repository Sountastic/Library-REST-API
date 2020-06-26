package com.project.library.api.domain.dto;

import com.project.library.api.domain.BookStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookEditionDto {
    private Long id;
    private Long titleId;
    private BookStatus bookStatus;
}
