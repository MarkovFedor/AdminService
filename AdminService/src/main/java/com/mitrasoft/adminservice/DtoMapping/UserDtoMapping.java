package com.mitrasoft.adminservice.DtoMapping;

import com.mitrasoft.adminservice.dto.UserDTO;
import com.mitrasoft.adminservice.entities.User;
import com.mitrasoft.adminservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDtoMapping {
    @Autowired
    private UserRepository userRepository;

    public UserDTO mapToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setRoles(user.getRoles());
        userDTO.setUsername(user.getUsername());
        return userDTO;
    }

    public User mapToUserEntity(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        return user;
    }
}
