package com.example.loginregistration.repo;

import com.example.loginregistration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<User,Integer> {
@Query
    public User findByEmail(String email);
@Query
    public User findByEmailAndPassword(String email, String password);
}
