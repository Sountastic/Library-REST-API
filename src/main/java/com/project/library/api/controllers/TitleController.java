package com.project.library.api.controllers;

import com.project.library.api.controllers.mappers.TitleMapper;
import com.project.library.api.domain.dto.TitleDto;
import com.project.library.api.exceptions.TitleNotFoundException;
import com.project.library.api.services.TitleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/title")
public class TitleController {

    private final TitleServiceImpl titleService;
    private final TitleMapper titleMapper;

    @GetMapping("/titles")
    @ResponseBody
    public List<TitleDto> getTitles() {
        return titleMapper.mapToTitleDtoList(titleService.getAllTitles());
    }

    @GetMapping("/{titleId}")
    @ResponseBody
    public TitleDto getTitle(@PathVariable("titleId") Long titleId) throws TitleNotFoundException {
        return titleMapper.mapToTitleDto(titleService.getTitleById(titleId).orElseThrow(TitleNotFoundException::new));
    }

    @DeleteMapping("{titleId}")
    public void deleteTitle(@PathVariable("titleId") Long titleId) {
        titleService.deleteTitleById(titleId);
    }

    @PutMapping("")
    public TitleDto updateTitle(@RequestBody TitleDto titleDto) {
        return titleMapper.mapToTitleDto(titleService.saveTitle(titleMapper.mapToTitle(titleDto)));
    }

    @PostMapping("")
    @ResponseBody
    public void createTitle(@RequestBody TitleDto titleDto) {
        titleService.saveTitle(titleMapper.mapToTitle(titleDto));
    }

}
