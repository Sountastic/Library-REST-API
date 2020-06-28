package com.project.library.api.services;

import com.project.library.api.domain.BookEdition;
import com.project.library.api.repositories.BookEditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookEditionServiceImpl implements BookEditionService {
    @Autowired
    BookEditionRepository bookEditionRepository;

    public List<BookEdition> getAllEditions() {
        return bookEditionRepository.findAll();
    }

    public Optional<BookEdition> getEditionById(Long id) {
        return bookEditionRepository.findById(id);
    }

    public BookEdition saveEdition(final BookEdition bookEdition) {
        return bookEditionRepository.save(bookEdition);
    }

    public void deleteEditionById(final Long id) {
        bookEditionRepository.deleteById(id);
    }
}
