package com.example.user_task.service;

import com.example.user_task.dto.Dto;
import com.example.user_task.exception.EmptyListException;
import com.example.user_task.exception.TaskNotFoundException;
import com.example.user_task.model.UserTask;
import com.example.user_task.repo.UserRepository;
import com.example.user_task.ui.RequestModel;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
@Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Dto createTask(Dto dto) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserTask userTask=modelMapper.map(dto,UserTask.class);
        StringBuilder stringBuilder=new StringBuilder(dto.getPassword());
        userTask.setEncryptedPassword(stringBuilder.reverse().toString());
        userTask=userRepository.save(userTask);

        return modelMapper.map(userTask,Dto.class);
    }

    @Override
    public List<Dto> getTask() {
    List<Dto> list=new ArrayList<>();


    Iterable<UserTask> iterable=userRepository.findAll();
        Iterator<UserTask> iterator= iterable.iterator();
        while (iterator.hasNext())
        {
            list.add(modelMapper.map(iterator.next(),Dto.class));
        }
        if(list.isEmpty()){
            throw new EmptyListException("list is empty");
        }
            return list;

    }

    @Override
    public Dto findTaskByTaskId(String uniqueTaskId) {

    UserTask userTask= findTaskId(uniqueTaskId);
        if(userTask==null)
        {
            throw new TaskNotFoundException("Task with id: "+uniqueTaskId+" not found");
        }
        return modelMapper.map(userTask,Dto.class);
    }

    @Override
    public void deleteTaskByTaskId(String uniqueTaskId) {
        UserTask userTask=findTaskId(uniqueTaskId);
        if(userTask==null)
        {
            throw new TaskNotFoundException("Task with id: "+uniqueTaskId+" not found");
        }
        userRepository.delete(userTask);
    }

    @Override
    public Dto updateTaskByTaskId(RequestModel requestModel, String uniqueTaskId) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserTask entity=findTaskId(uniqueTaskId);
        if (entity==null)
        {
            throw new TaskNotFoundException("Task with "+uniqueTaskId+" not found");
        }
        entity.setTaskName(requestModel.getTaskName());
        entity.setEmail(requestModel.getEmail());
        entity.setAssignedTo(requestModel.getAssignedTo());
        entity.setCompleted(requestModel.isCompleted());
        entity.setStartDate(requestModel.getStartDate());
        entity.setEncryptedPassword(requestModel.getPassword());
        entity.setEndDate(requestModel.getEndDate());
        userRepository.save(entity);
        return modelMapper.map(entity,Dto.class);


    }

    private UserTask findTaskId(String uniqueTaskId) {

        UserTask userTask= userRepository.findByUniqueTaskId(uniqueTaskId);
        return userTask;
    }
}
