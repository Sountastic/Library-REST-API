package com.project.library.api.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@Entity(name = "bookEdition")
public class BookEdition extends BaseEntity {

    @NonNull
    @ManyToOne
    @JoinColumn(name = "titleId")
    private Title title;

    @NonNull
    @Column(name = "status")
    private BookStatus bookStatus;

}
