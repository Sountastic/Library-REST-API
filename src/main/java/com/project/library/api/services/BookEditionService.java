package com.project.library.api.services;

import com.project.library.api.domain.BookEdition;

import java.util.List;
import java.util.Optional;

public interface BookEditionService {

    List<BookEdition> getAllEditions();

    Optional<BookEdition> getEditionById(Long id);

    BookEdition saveEdition(final BookEdition bookEdition);

    void deleteEditionById(final Long id);
}
