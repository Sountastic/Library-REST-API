package com.project.library.api.services;

import com.project.library.api.domain.Rental;

import java.util.List;
import java.util.Optional;

public interface RentalService {

    List<Rental> getAllRentals();

    Optional<Rental> getRentalById(final Long id);

    Rental saveRental(final Rental rental);

    void deleteRentalById(final Long id);
}
