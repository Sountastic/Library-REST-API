package com.project.library.api.domain.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate joiningDate;
}
