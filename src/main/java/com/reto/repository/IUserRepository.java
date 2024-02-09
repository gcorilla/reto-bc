package com.reto.repository;

import com.reto.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUserRepository extends JpaRepository<UserModel, Integer> {


    public UserModel findUserModelByCellphone(String cellphone);
}
