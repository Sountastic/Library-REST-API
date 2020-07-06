package com.project.library.api.domain.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RentalDto {
    private Long id;
    private Long bookId;
    private Long userId;
    private LocalDate rentalDate;
    private LocalDate returnDate;
}
