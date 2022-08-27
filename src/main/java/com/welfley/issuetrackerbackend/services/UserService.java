package com.welfley.issuetrackerbackend.services;


import com.welfley.issuetrackerbackend.models.UserResource;
import com.welfley.issuetrackerbackend.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NonUniqueResultException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //GET
    public UserResource getUser(UserResource userResource) {
        return userRepository.findByUsernameAndPassword(userResource.getUsername(), userResource.getPassword());
    }

    public boolean getUserByUsername(String username, String password) {
        boolean usernamePresent;
        boolean passwordPresent;
        try {
            usernamePresent = userRepository.findByUsername(username) != null ? true : false;
            passwordPresent = userRepository.findByPassword(password) != null ? true : false;
        } catch (NonUniqueResultException nre) {
            return true;
        }
        return usernamePresent && passwordPresent;
    }

    public boolean findUserByUsername(String username){
        boolean usernamePresent;
        try{
            usernamePresent = userRepository.findByUsername(username) != null ? true : false;
        } catch (NonUniqueResultException nre) {
            return true;
        }
        return usernamePresent;
    }

    //POST
    public void saveUser(UserResource userResource) {
        userRepository.save(userResource);
    }

}
