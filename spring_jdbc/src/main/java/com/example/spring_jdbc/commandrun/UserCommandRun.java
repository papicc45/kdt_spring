package com.example.spring_jdbc.commandrun;

import com.example.spring_jdbc.dto.UserDTO;
import com.example.spring_jdbc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCommandRun implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {
        UserDTO user1 = UserDTO.builder()
                                                    .id(3)
                                                    .name("동준")
                                                    .address("seoul")
                                                    .build();
        UserDTO user2 = UserDTO.builder()
                                                    .id(4)
                                                    .name("동준")
                                                    .address("seoul")
                                                    .build();
        userRepository.insert(user1);
        userRepository.insert(user2);
        userRepository.deleteById(3L);
    }
}
