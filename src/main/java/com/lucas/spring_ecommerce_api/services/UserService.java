package com.lucas.spring_ecommerce_api.services;

import com.lucas.spring_ecommerce_api.entities.User;
import com.lucas.spring_ecommerce_api.repository.UserRepository;
import com.lucas.spring_ecommerce_api.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers () {
        return userRepository.findAll();
    }

    public User findUserById (Integer id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    public User update(Integer id, User newUser) {
        User oldUser = userRepository.getReferenceById(id);
        oldUser.setName(newUser.getName());
        oldUser.setEmail(newUser.getEmail());
        oldUser.setPhone(newUser.getPhone());

        return userRepository.save(oldUser);
    }
}
