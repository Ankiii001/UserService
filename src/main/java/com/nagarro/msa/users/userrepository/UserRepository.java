package com.nagarro.msa.users.userrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.msa.users.userbean.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
