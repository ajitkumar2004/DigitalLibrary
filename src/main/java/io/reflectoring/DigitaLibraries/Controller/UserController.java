package io.reflectoring.DigitaLibraries.Controller;

import io.reflectoring.DigitaLibraries.Model.user;
import io.reflectoring.DigitaLibraries.Services.Serviced;
import io.reflectoring.DigitaLibraries.Dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Employee")
public class UserController {

    @Autowired
    private Serviced service;

    @PostMapping("/add")
    public void add(@RequestBody UserDTO dto) {
        user users = dto.toAdd();
        service.add(users);
    }
}
