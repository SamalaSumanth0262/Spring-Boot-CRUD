package com.example.crud.service;
import com.example.crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.crud.repository.UserRepository;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }

    public User updateUser(Long userId, User userDetails){
        User user = userRepository.findById(userId).get();
        user.setFirstName(userDetails.getFirstName());
        user.setEmail(userDetails.getEmail());
        return userRepository.save(user);
    }
}