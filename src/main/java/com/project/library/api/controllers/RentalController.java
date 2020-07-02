package com.project.library.api.controllers;

import com.project.library.api.controllers.mappers.RentalMapper;
import com.project.library.api.domain.dto.RentalDto;
import com.project.library.api.exceptions.RentalNotFoundException;
import com.project.library.api.services.RentalServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/rental")
public class RentalController {

    private final RentalServiceImpl rentalService;
    private final RentalMapper rentalMapper;

    @GetMapping("/rentals")
    @ResponseBody
    public List<RentalDto> getRentals() {
        return rentalMapper.mapToRentalDtoList(rentalService.getAllRentals());
    }

    @GetMapping("/{rentalId}")
    @ResponseBody
    public RentalDto getRentalById(@PathVariable("rentalId") Long rentalId) throws RentalNotFoundException {
        return rentalMapper.mapToRentalDto(rentalService.getRentalById(rentalId).orElseThrow(RentalNotFoundException::new));
    }

    @DeleteMapping("/{rentalId}")
    public void deleteRental(@PathVariable("rentalId") Long rentalId) {
        rentalService.deleteRentalById(rentalId);
    }

    @PutMapping("/{rentalId}")
    public RentalDto updateRental(@PathVariable("rentalId") Long rentalId, @RequestBody RentalDto rentalDto) {
        return rentalMapper.mapToRentalDto(rentalService.saveRental(rentalMapper.matToRental(rentalDto)));
    }

    @PostMapping("")
    @ResponseBody
    public void createRental(@RequestBody RentalDto rentalDto) {
        rentalService.saveRental(rentalMapper.matToRental(rentalDto));
    }
}
