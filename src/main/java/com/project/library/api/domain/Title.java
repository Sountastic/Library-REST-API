package com.project.library.api.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @Column(name = "releaseYear")
    private Integer releaseYear;

    @NonNull
    @OneToMany(
            targetEntity = BookEdition.class,
            mappedBy = "title",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<BookEdition> bookEditions = new ArrayList<>();

    public Title(String title, String author, Integer releaseYear) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
    }
}
