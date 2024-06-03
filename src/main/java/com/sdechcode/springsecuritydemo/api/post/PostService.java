package com.sdechcode.springsecuritydemo.api.post;

import com.sdechcode.springsecuritydemo.dto.post.PostDto;
import com.sdechcode.springsecuritydemo.entity.PostEntity;
import com.sdechcode.springsecuritydemo.repo.PostRepository;
import com.sdechcode.springsecuritydemo.system.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public List<PostDto> findAll() {
        List<PostEntity> postEntities = this.postRepository.findAll();
        return this.postMapper.toPostsDto(postEntities);
    }

    public PostDto findById(Long postID) {
        PostEntity postEntity = this.postRepository.findById(postID)
                .orElseThrow(() -> new ObjectNotFoundException("post", postID));
        return this.postMapper.toPostDto(postEntity);
    }

    public PostDto save(PostDto request) {
        PostEntity postEntity = this.postMapper.fromPostDto(request);
        PostEntity newPost = this.postRepository.save(postEntity);
        return this.postMapper.toPostDto(newPost);
    }

    public PostDto update(Long postID, PostDto request) {
        PostEntity oldPost = this.postRepository.findById(postID)
                .orElseThrow(() -> new ObjectNotFoundException("post", postID));
        oldPost.setTitle(request.title());
        oldPost.setContent(request.content());
        oldPost.setImage(request.image());
        PostEntity updatedPost = this.postRepository.save(oldPost);
        return this.postMapper.toPostDto(updatedPost);
    }

    public void delete(Long postID) {
        this.postRepository.findById(postID)
                .orElseThrow(() -> new ObjectNotFoundException("post", postID));
        this.postRepository.deleteById(postID);
    }

}
