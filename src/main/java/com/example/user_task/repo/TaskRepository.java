package com.example.user_task.repo;

import com.example.user_task.model.UserTask;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<UserTask,Integer> {
    @Query
    public UserTask findByUniqueTaskId(Integer uniqueTaskId);

}
