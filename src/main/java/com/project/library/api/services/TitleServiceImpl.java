package com.project.library.api.services;

import com.project.library.api.domain.Title;
import com.project.library.api.repositories.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TitleServiceImpl implements TitleService {
    @Autowired
    TitleRepository titleRepository;

    @Override
    public List<Title> getAllTitles() {
        return titleRepository.findAll();
    }

    @Override
    public Optional<Title> getTitleById(final Long id) {
        return titleRepository.findById(id);
    }

    @Override
    public Title saveTitle(final Title title) {
        return titleRepository.save(title);
    }

    @Override
    public void deleteTitleById(final Long id) {
        titleRepository.deleteById(id);
    }
}
