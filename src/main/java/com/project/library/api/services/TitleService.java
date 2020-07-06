package com.project.library.api.services;

import com.project.library.api.domain.Title;

import java.util.List;
import java.util.Optional;

public interface TitleService {

    List<Title> getAllTitles();

    Optional<Title> getTitleById(final Long id);

    Title saveTitle(final Title title);

    void deleteTitleById(final Long id);
}
