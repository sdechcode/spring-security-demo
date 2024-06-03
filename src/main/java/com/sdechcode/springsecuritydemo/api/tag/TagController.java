package com.sdechcode.springsecuritydemo.api.tag;

import com.sdechcode.springsecuritydemo.dto.tag.TagDto;
import com.sdechcode.springsecuritydemo.system.Result;
import com.sdechcode.springsecuritydemo.system.StatusCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "${api.endpoint.base-url}/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @GetMapping(value = "")
    public Result findAllTags() {
        List<TagDto> tags = tagService.findAll();
        return new Result(true, StatusCode.SUCCESS, "Find all success", tags);
    }

    @GetMapping(value = "/{tagID}")
    public Result findTagByID(@PathVariable(name = "tagID") Long tagID) {
        TagDto tag = tagService.findById(tagID);
        return new Result(true, StatusCode.SUCCESS, "Find one success", tag);
    }

    @PostMapping(value = "")
    public Result addTag(@Valid @RequestBody TagDto request) {
        TagDto tagDto = tagService.save(request);
        return new Result(true, StatusCode.SUCCESS, "Add success", tagDto);
    }

    @PutMapping(value = "/{tagID}")
    public Result updateTag(@PathVariable(name = "tagID") Long tagID, @Valid @RequestBody TagDto request) {
        TagDto tagDto = tagService.update(tagID, request);
        return new Result(true, StatusCode.SUCCESS, "Update success", tagDto);
    }

    @DeleteMapping(value = "/{tagID}")
    public Result deleteTag(@PathVariable(name = "tagID") Long tagID) {
        tagService.delete(tagID);
        return new Result(true, StatusCode.SUCCESS, "Delete success");
    }

}
