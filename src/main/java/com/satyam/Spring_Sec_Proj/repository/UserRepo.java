package com.satyam.Spring_Sec_Proj.repository;

import com.satyam.Spring_Sec_Proj.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    User findByUserName(String name);
}
