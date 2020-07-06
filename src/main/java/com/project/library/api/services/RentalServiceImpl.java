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

    @Override
    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    @Override
    public Optional<Rental> getRentalById(final Long id) {
        return rentalRepository.findById(id);
    }

    @Override
    public Rental saveRental(final Rental rental) {
        return rentalRepository.save(rental);
    }

    @Override
    public void deleteRentalById(final Long id) {
        rentalRepository.deleteById(id);
    }
}
