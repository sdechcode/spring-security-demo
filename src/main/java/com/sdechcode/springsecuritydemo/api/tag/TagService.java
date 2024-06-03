package com.sdechcode.springsecuritydemo.api.tag;

import com.sdechcode.springsecuritydemo.dto.tag.TagDto;
import com.sdechcode.springsecuritydemo.repo.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    public List<TagDto> findAll() {
        return null;
    }

    public TagDto findById(Long tagID) {
        return null;
    }

    public TagDto save(TagDto request) {
        return null;
    }

    public TagDto update(Long tagID, TagDto request) {
        return null;
    }

    public void delete(Long tagID) {

    }

}
