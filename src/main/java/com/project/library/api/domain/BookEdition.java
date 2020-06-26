package com.project.library.api.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@Entity(name = "bookCopy")
public class BookEdition extends BaseEntity {

    @NonNull
    @Column(name = "titleId")
    private Long titleId;

    @NonNull
    @Column(name = "status")
    private BookStatus bookStatus;


}
