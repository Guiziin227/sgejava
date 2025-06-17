package com.github.guiziin227.sgejava.service;

import com.github.guiziin227.sgejava.exceptions.DbIntegrityVioletionException;
import com.github.guiziin227.sgejava.model.User;
import com.github.guiziin227.sgejava.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    @Transactional
    public User createUser(User user) {
        logger.info("Creating user");
        try{
            return userRepository.save(user);
        } catch (Exception e) {
            logger.error("Error creating user: {}", e.getMessage());
            throw new DbIntegrityVioletionException(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        logger.info("Retrieving all users");
        return userRepository.findAll();
    }


}
