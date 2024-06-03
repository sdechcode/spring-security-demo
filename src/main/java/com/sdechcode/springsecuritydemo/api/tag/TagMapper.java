package com.sdechcode.springsecuritydemo.api.tag;

import com.sdechcode.springsecuritydemo.dto.tag.TagDto;
import com.sdechcode.springsecuritydemo.entity.TagEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TagMapper {
    List<TagDto> toTagsDto(List<TagEntity> tagEntities);
    TagDto toTagDto(TagEntity tagEntity);
    TagEntity fromTagDto(TagDto tagDto);
}
