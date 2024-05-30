package com.sdechcode.springsecuritydemo.api.tag;

import com.sdechcode.springsecuritydemo.repo.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

}
