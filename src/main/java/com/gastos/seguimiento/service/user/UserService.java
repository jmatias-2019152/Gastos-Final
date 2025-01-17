package com.gastos.seguimiento.service.user;
import com.gastos.seguimiento.model.user.User;
import com.gastos.seguimiento.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User findById(String id){
        return userRepository.findById(id).orElse(null);
    }
    public User save(User user){
        return userRepository.save(user);
    }
    public void delete(String id){
        userRepository.deleteById(id);
    }
}
