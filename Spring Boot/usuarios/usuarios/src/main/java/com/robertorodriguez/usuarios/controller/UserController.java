package com.robertorodriguez.usuarios.controller;

import com.robertorodriguez.usuarios.model.User;
import com.robertorodriguez.usuarios.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getALLUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @PostMapping
    public String createUser(@RequestBody User user){
        try {
            User result = userService.saveUser(user);
            if ("ERROR_NOMBRE_REPETIDO".equals(result.getFirstName())) {
                return "El nombre ya existe en la base de datos!";
            }
            if ("ERROR_APELLIDO_REPETIDO".equals(result.getLastName())) {
                return "El apellido ya existe en la base de datos!";
            }
            if ("ERROR_EMAIL_REPETIDO".equals(result.getEmail())) {
                return "El email ya  existe en la base de datos!";
            }
            return "Usuario agregado correctamente";
        } catch (InvalidEmail invalid) {
            return invalid.getMessage();
        }
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable Integer id, @RequestBody User user){
        try {
            User result = userService.updateUser(id, user);
            if (result == null) {
                return "Usuario no encontrado";
            }
            if ("ERROR_NOMBRE_REPETIDO".equals(result.getFirstName())) {
                return "El nombre ya existe en la base de datos!";
            }
            if ("ERROR_APELLIDO_REPETIDO".equals(result.getLastName())) {
                return "El apellido ya existe en la base de datos!";
            }
            if ("ERROR_EMAIL_REPETIDO".equals(result.getEmail())) {
                return "El email ya existe en la base de datos!";
            }
            return "Usuario actualizado correctamente";
        } catch (InvalidEmail invalid) {
            return invalid.getMessage();
        }
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return "Usuario eliminado correctamente";
    }
}
