package br.com.portalturismo.backend.controller;

import br.com.portalturismo.backend.model.User;
import br.com.portalturismo.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> findAll() {
        return  userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id) {
        return userRepository.findById(id).get();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User user){
        User existingUser = userRepository.findById(id).get();
        existingUser.setNome(user.getNome());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id){
        try {
            userRepository.deleteById(id);
            return "User deleted successfully";
        }catch (Exception e){
            return "User not found";
        }
    }

}
