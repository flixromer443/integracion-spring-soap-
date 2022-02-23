package com.api1.api1.repositories;


import com.api1.api1.orm.User;

import org.springframework.data.jpa.repository.JpaRepository;



public interface IUserJpaRepositorty extends JpaRepository<User,Integer> {
   
}
