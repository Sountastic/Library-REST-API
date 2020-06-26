package com.project.library.api.domain;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@Entity(name = "rental")
public class Rental extends BaseEntity {
    @NonNull
    @Column(name = "bookId")
    private Long bookId;

    @NonNull
    @Column(name = "userId")
    private Long userId;

    @NonNull
    @Column(name = "rentalDate")
    private Date rentalDate;

    @NonNull
    @Column(name = "returnDate")
    private Date returnDate;

}
