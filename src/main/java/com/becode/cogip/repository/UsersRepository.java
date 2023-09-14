package com.becode.cogip.repository;

import com.becode.cogip.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<UsersModel, Integer> {

    Optional<UsersModel> findByLoginAndPassword(String login, String password);
}
