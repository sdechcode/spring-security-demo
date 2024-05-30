package com.sdechcode.springsecuritydemo.api.post;

import com.sdechcode.springsecuritydemo.dto.post.PostDto;
import com.sdechcode.springsecuritydemo.repo.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<PostDto> findAll() {
        return null;
    }

    public PostDto findById(Long postID) {
        return null;
    }

    public PostDto save(PostDto request) {
        return null;
    }

    public PostDto update(Long postID, PostDto request) {
        return null;
    }

    public void delete(Long postID) {

    }

}
