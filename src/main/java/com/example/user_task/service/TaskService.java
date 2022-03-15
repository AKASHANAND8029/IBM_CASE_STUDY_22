package com.example.user_task.service;

import com.example.user_task.dto.Dto;
import com.example.user_task.ui.RequestModel;

import java.util.List;

public interface TaskService {
    public Dto createTask(Dto dto);
    List<Dto> getTask();
    public Dto findTaskByTaskId(Integer uniqueTaskId);
    public void deleteTaskByTaskId(Integer uniqueTaskId);
    Dto updateTaskByTaskId(RequestModel requestModel, Integer uniqueTaskId);
}
