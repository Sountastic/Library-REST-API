package com.project.library.api.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@Entity(name = "user")
public class User extends BaseEntity {

    @NonNull
    @Column(name = "firstName")
    private String firstName;

    @NonNull
    @Column(name = "lastName")
    private String lastName;

    @Column(name = "joiningDate")
    private LocalDate joiningDate;

    @OneToMany(
            targetEntity = Rental.class,
            mappedBy = "userId",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Rental> rentals = new ArrayList<>();

    public User(String firstName, String lastName, LocalDate joiningDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.joiningDate = joiningDate;
    }
}
