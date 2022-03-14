package com.example.user_task.service;

import com.example.user_task.dto.Dto;
import com.example.user_task.ui.RequestModel;

import java.util.List;

public interface UserService {
    public Dto createTask(Dto dto);
    List<Dto> getTask();
    public Dto findTaskByTaskId(String uniqueTaskId);
    public void deleteTaskByTaskId(String uniqueTaskId);
    Dto updateTaskByTaskId(RequestModel requestModel, String uniqueTaskId);
}
