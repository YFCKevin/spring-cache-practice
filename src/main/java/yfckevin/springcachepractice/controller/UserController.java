package yfckevin.springcachepractice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yfckevin.springcachepractice.entity.User;
import yfckevin.springcachepractice.service.UserService;

import java.util.UUID;

@Tag(name = "Member")
@RequestMapping("/api/v1.0")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "查詢會員資料")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                content = {
                    @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = User.class))
                    )
                }
            )
    })
    @GetMapping("users/{id}")
    public User getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @Operation(summary = "建立會員")
    @PostMapping("users")
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @Operation(summary = "更新會員資料")
    @PutMapping("users")
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @Operation(summary = "刪除會員")
    @DeleteMapping("users/{id}")
    public void del(@PathVariable("id") Long id){
        userService.delete(id);
    }
}
