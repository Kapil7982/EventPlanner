package com.event.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.event.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{


}
