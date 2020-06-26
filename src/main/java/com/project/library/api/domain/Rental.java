package com.project.library.api.domain;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@Entity(name = "rental")
public class Rental extends BaseEntity {

    @NonNull
    @OneToMany
    @JoinColumn(name = "bookId")
    private List<BookEdition> books = new ArrayList<>();

    @NonNull
    @ManyToOne
    @JoinColumn(name = "userId")
    private User userId;

    @NonNull
    @Column(name = "rentalDate")
    private Date rentalDate;

    @NonNull
    @Column(name = "returnDate")
    private Date returnDate;

}
