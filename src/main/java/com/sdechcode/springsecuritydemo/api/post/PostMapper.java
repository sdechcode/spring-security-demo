package com.sdechcode.springsecuritydemo.api.post;

import com.sdechcode.springsecuritydemo.dto.post.PostDto;
import com.sdechcode.springsecuritydemo.entity.PostEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {
    List<PostDto> toPostsDto(List<PostEntity> postEntities);
    PostDto toPostDto(PostEntity postEntity);
    PostEntity fromPostDto(PostDto postDto);
}
