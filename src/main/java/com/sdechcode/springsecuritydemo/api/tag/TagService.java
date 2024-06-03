package com.sdechcode.springsecuritydemo.api.tag;

import com.sdechcode.springsecuritydemo.dto.tag.TagDto;
import com.sdechcode.springsecuritydemo.entity.TagEntity;
import com.sdechcode.springsecuritydemo.repo.TagRepository;
import com.sdechcode.springsecuritydemo.system.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;
    private final TagMapper tagMapper;

    public List<TagDto> findAll() {
        List<TagEntity> tagEntities = this.tagRepository.findAll();
        return this.tagMapper.toTagsDto(tagEntities);
    }

    public TagDto findById(Long tagID) {
        TagEntity tagEntity = this.tagRepository.findById(tagID)
                .orElseThrow(() -> new ObjectNotFoundException("tag", tagID));
        return this.tagMapper.toTagDto(tagEntity);
    }

    public TagDto save(TagDto request) {
        TagEntity newTag = this.tagMapper.fromTagDto(request);
        TagEntity savedTag = this.tagRepository.save(newTag);
        return this.tagMapper.toTagDto(savedTag);
    }

    public TagDto update(Long tagID, TagDto request) {
        TagEntity oldTag = this.tagRepository.findById(tagID)
                .orElseThrow(() -> new ObjectNotFoundException("tag", tagID));
        oldTag.setName(request.name());
        TagEntity updatedTag = this.tagRepository.save(oldTag);
        return this.tagMapper.toTagDto(updatedTag);
    }

    public void delete(Long tagID) {
        this.tagRepository.findById(tagID)
                .orElseThrow(() -> new ObjectNotFoundException("tag", tagID));
        this.tagRepository.deleteById(tagID);
    }

}
