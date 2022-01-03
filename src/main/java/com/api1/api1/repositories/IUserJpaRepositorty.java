package com.api1.api1.repositories;

import java.util.List;

import com.api1.api1.orm.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IUserJpaRepositorty extends JpaRepository<User,Integer> {
   
}
