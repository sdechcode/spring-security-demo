package com.sdechcode.springsecuritydemo.api.user;

import com.sdechcode.springsecuritydemo.dto.user.UserDto;
import com.sdechcode.springsecuritydemo.system.Result;
import com.sdechcode.springsecuritydemo.system.StatusCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.endpoint.base-url}/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "")
    public Result findAllUsers() {
        List<UserDto> users = userService.findAll();
        return new Result(true, StatusCode.SUCCESS, "Find all success", users);
    }

    @GetMapping(value = "/{userID}")
    public Result findUserByID(@PathVariable(name = "userID") Long userID) {
        UserDto user = userService.findById(userID);
        return new Result(true, StatusCode.SUCCESS, "Find one success", user);
    }

    @PostMapping(value = "")
    public Result addUser(@Valid @RequestBody UserDto request) {
        UserDto userDto = userService.save(request);
        return new Result(true, StatusCode.SUCCESS, "Add success", userDto);
    }

    @PutMapping(value = "/{userID}")
    public Result updateUser(@PathVariable(name = "userID") Long userID, @Valid @RequestBody UserDto request) {
        UserDto userDto = userService.update(userID, request);
        return new Result(true, StatusCode.SUCCESS, "Update success", userDto);
    }

    @DeleteMapping(value = "/{userID}")
    public Result deleteUser(@PathVariable(name = "userID") Long userID) {
        userService.delete(userID);
        return new Result(true, StatusCode.SUCCESS, "Delete success");
    }

}
