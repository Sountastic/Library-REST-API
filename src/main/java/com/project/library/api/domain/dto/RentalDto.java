package com.project.library.api.domain.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RentalDto {
    private Long id;
    private Long bookId;
    private Long userId;
    private Date rentalDate;
    private Date returnDate;
}
