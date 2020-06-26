package com.project.library.api.controllers.mappers;

import com.project.library.api.domain.BookEdition;
import com.project.library.api.domain.Rental;
import com.project.library.api.domain.dto.BookEditionDto;
import com.project.library.api.domain.dto.RentalDto;
import com.project.library.api.repositories.BookEditionRepository;
import com.project.library.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RentalMapper {

    @Autowired
    UserRepository userRepository;
    @Autowired
    BookEditionRepository bookEditionRepository;

    public Rental matToRental(final RentalDto rentalDto) {
        return new Rental(
                bookEditionRepository.findById(rentalDto.getBookId()).get(),
                userRepository.findById(rentalDto.getUserId()).get(),
                rentalDto.getRentalDate(),
                rentalDto.getReturnDate()
        );
    }

    public RentalDto mapToRentalDto(final Rental rental) {
        return new RentalDto(
                rental.getId(),
                rental.getBookEditionId().getId(),
                rental.getUserId().getId(),
                rental.getRentalDate(),
                rental.getReturnDate()
        );
    }

    public List<RentalDto> mapToRentalDtoList(final List<Rental> rentalList) {
        return rentalList.stream()
                .map(t -> new RentalDto(
                        t.getId(),
                        t.getBookEditionId().getId(),
                        t.getUserId().getId(),
                        t.getRentalDate(),
                        t.getReturnDate()))
                .collect(Collectors.toList());
    }

}
