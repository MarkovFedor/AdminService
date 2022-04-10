package com.mitrasoft.adminservice.controller;

import com.mitrasoft.adminservice.DtoMapping.UserDtoMapping;
import com.mitrasoft.adminservice.dto.UserDTO;
import com.mitrasoft.adminservice.entities.User;
import com.mitrasoft.adminservice.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/adminservice")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private UserDtoMapping userDtoMapping;

    @GetMapping("/test")
    public ResponseEntity testMethod() {
        System.out.println("FUCK YOU");
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/getallusers")
    public ResponseEntity getallusers() {
        List<User> users = adminService.getAllUsers();
        List<UserDTO> userDTOS = users.stream()
                .map(i -> userDtoMapping.mapToUserDTO(i))
                .collect(Collectors.toList());
        System.out.println(userDTOS);
        return new ResponseEntity(userDTOS, HttpStatus.OK);
    }
}
