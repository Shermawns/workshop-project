package com.Shermawn.demo.services;
import com.Shermawn.demo.models.UserModel;
import com.Shermawn.demo.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserModel> findAll(){
        return userRepository.findAll();
    }

    public UserModel findById(Long id){
        Optional <UserModel> obj = userRepository.findById(id);
        return obj.get();
    }

    public UserModel insert (UserModel obj){
        return userRepository.save(obj);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
