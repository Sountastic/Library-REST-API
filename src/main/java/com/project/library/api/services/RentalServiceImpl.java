package com.project.library.api.services;

import com.project.library.api.domain.Rental;
import com.project.library.api.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentalServiceImpl implements RentalService {
    @Autowired
    RentalRepository rentalRepository;

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public Optional<Rental> getRentalById(final Long id) {
        return rentalRepository.findById(id);
    }

    public Rental saveRental(final Rental rental) {
        return rentalRepository.save(rental);
    }

    public void deleteRentalById(final Long id) {
        rentalRepository.deleteById(id);
    }
}
