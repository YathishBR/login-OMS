package com.callawaygolf.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.callawaygolf.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	User findByUserName(String userName);
	User findByPassword(String password);
	
	
}
