package pl.project.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    @CrossOrigin(origins = "*")
    public List<UserEntity> getAllUserList() {
        return userService.getAllUserList();
    }

    @PostMapping("/newUser")
    @CrossOrigin(origins = "*")
    public UserEntity addNewUser(@RequestBody UserEntity userEntity) {
        return userService.addUser(userEntity);
    }

    @PutMapping(value = "/updateUser")
    @CrossOrigin(origins = "*")
    public UserEntity updateUser(@RequestBody UserEntity userEntity) {
        return userService.addUser(userEntity);
    }

    @DeleteMapping(value = "/{id}")
    @CrossOrigin(origins = "*")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

    @GetMapping("/login")
    @CrossOrigin(origins = "*")
    public UserEntity getUserByLoginAndPassword(@RequestParam String email, @RequestParam String password) {
        return userService.getUserByEmailAndPassword(email, password);
    }

}
