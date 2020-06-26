package com.project.library.api.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@Entity(name = "title")
public class Title extends BaseEntity {

    @NonNull
    @Column(name = "title")
    private String title;

    @NonNull
    @Column(name = "author")
    private String author;

    @NonNull
    @Column(name = "publishingYear")
    private Integer publishingYear;
}
