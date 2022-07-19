package Controller;

import Repository.UserRepositry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UserController {
    private final UserRepositry userRepositry;
    @GetMapping("/users")
    public List<User>getUsers(){
        return (List<User>) userRepositry.findAll();
    }

    @PostMapping("/users")
    void addUser(@RequestBody User user){
        userRepositry.save(user);
    }
}
