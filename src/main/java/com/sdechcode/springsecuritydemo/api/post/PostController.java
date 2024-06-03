package com.sdechcode.springsecuritydemo.api.post;

import com.sdechcode.springsecuritydemo.dto.post.PostDto;
import com.sdechcode.springsecuritydemo.system.Result;
import com.sdechcode.springsecuritydemo.system.StatusCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "${api.endpoint.base-url}/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping(value = "")
    public Result findAllPosts() {
        List<PostDto> posts = postService.findAll();
        return new Result(true, StatusCode.SUCCESS, "Find all success", posts);
    }

    @GetMapping(value = "/{postID}")
    public Result findPostByID(@PathVariable(name = "postID") Long postID) {
        PostDto post = postService.findById(postID);
        return new Result(true, StatusCode.SUCCESS, "Find one success", post);
    }

    @PostMapping(value = "")
    public Result addPost(@Valid @RequestBody PostDto request) {
        PostDto postDto = postService.save(request);
        return new Result(true, StatusCode.SUCCESS, "Add success", postDto);
    }

    @PutMapping(value = "/{postID}")
    public Result updatePost(@PathVariable(name = "postID") Long postID, @Valid @RequestBody PostDto request) {
        PostDto postDto = postService.update(postID, request);
        return new Result(true, StatusCode.SUCCESS, "Update success", postDto);
    }

    @DeleteMapping(value = "/{postID}")
    public Result deletePost(@PathVariable(name = "postID") Long postID) {
        postService.delete(postID);
        return new Result(true, StatusCode.SUCCESS, "Delete success");
    }

}
