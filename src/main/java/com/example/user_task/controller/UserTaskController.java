package com.example.user_task.controller;

import com.example.user_task.dto.Dto;
import com.example.user_task.service.TaskService;
import com.example.user_task.ui.RequestModel;
import com.example.user_task.ui.ResponseModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
public class UserTaskController {
    private final TaskService taskService;
    private final ModelMapper modelMapper;
@Autowired
    public UserTaskController(TaskService taskService, ModelMapper modelMapper) {
        this.taskService = taskService;
        this.modelMapper = modelMapper;
    }
    @Operation(summary = "user_task api create new task")
    @ApiResponse(responseCode = "201",description = "created successfully")
    @PostMapping("/create")
    public ResponseEntity<ResponseModel> createTask(@RequestBody RequestModel requestModel)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Dto dto=modelMapper.map(requestModel,Dto.class);
        dto.setUniqueTaskId(new Random().nextInt(10000));
        dto= taskService.createTask(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(dto,ResponseModel.class));
    }
    @GetMapping("/list")
    public ResponseEntity<List<ResponseModel>> getUsers()
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<ResponseModel> list=new ArrayList<>();
        List<Dto> dtos= taskService.getTask();
        for (Dto d:dtos)
        {
            list.add(modelMapper.map(d,ResponseModel.class));
        }
        return ResponseEntity.ok(list);
    }
    @GetMapping("/task/{id}")
    public ResponseEntity<ResponseModel> findUserByUserId(@PathVariable("id") Integer id)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return ResponseEntity.ok(modelMapper.map(taskService.findTaskByTaskId(id),ResponseModel.class));

    }
    @DeleteMapping("/task/{id}")
    public ResponseEntity<?> deleteUserByUserId(@PathVariable("id") Integer id)
    {
        taskService.deleteTaskByTaskId(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PutMapping("/task/{id}")
    public ResponseEntity<ResponseModel> updateUserByUserId(@RequestBody RequestModel requestModel,@PathVariable("id") Integer id )
    {  modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return ResponseEntity.ok(modelMapper.map(taskService.updateTaskByTaskId(requestModel,id),ResponseModel.class));
    }
}
