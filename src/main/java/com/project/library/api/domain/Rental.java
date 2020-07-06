package com.project.library.api.domain;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@Entity(name = "rental")
public class Rental extends BaseEntity {

    @NonNull
    @ManyToOne
    @JoinColumn(name = "bookEditionId")
    private BookEdition bookEditionId;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "userId")
    private User userId;

    @NonNull
    @Column(name = "rentalDate")
    private LocalDate rentalDate;

    @NonNull
    @Column(name = "returnDate")
    private LocalDate returnDate;

}
