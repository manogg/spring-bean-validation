package com.mlv.springbeanvalidation.service;

import com.mlv.springbeanvalidation.dto.UserRequestData;
import com.mlv.springbeanvalidation.entity.Users;
import com.mlv.springbeanvalidation.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users saveUsers(UserRequestData userRequestData){

        Users usr=Users.build(0,userRequestData.getUserName(),userRequestData.getUserEmail(),userRequestData.getUserMobile(),userRequestData.getUserAge(),userRequestData.getUserNationality());
        userRepository.save(usr);
        return usr;

    }

    public Optional<Users> getUserByID(Integer id) throws NoSuchElementException {

        Optional<Users> usr=userRepository.findById(id);

        if(usr.get()!=null){
            return usr;
        }
        else{
            throw new NoSuchElementException("User Not Found");
        }
    }
}
