package com.project.library.api.repositories;

import com.project.library.api.domain.BookEdition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookEditionRepository extends JpaRepository<BookEdition, Long> {
}
