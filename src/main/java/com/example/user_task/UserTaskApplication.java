package com.example.user_task;

import com.example.user_task.exception.ErrorResponseModel;
import com.example.user_task.model.UserTask;
import com.example.user_task.repo.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class UserTaskApplication implements CommandLineRunner {
    private final UserRepository userRepository;

    public UserTaskApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(UserTaskApplication.class, args);
    }
@Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();

    }
    @Bean
    public ErrorResponseModel errorResponseModel()
    {
        return  new ErrorResponseModel();
    }


    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new UserTask(1, UUID.randomUUID().toString(),"ProjectXYZ","Infrastructure Project",true,"02-03-22","31-03-22","Manager1","Abhinav","abc@email.com","abc@123"));
    }
}
