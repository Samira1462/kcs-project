package ir.karafarinbank.controller;

import ir.karafarinbank.message.Response;
import ir.karafarinbank.model.User;
import ir.karafarinbank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path="/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/user")
    public Response postUser(@RequestBody @Valid User user) {
        return userService.add(user);
    }

    @GetMapping(path="/user")
//    @PreAuthorize("@permissionService.hasPermission('api/user', 'GET')")
    public @ResponseBody
    Response getUsers() {
        Response k = userService.findAll();
        return k;
    }
}
