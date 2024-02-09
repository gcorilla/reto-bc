package com.reto.repository;

import com.reto.model.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepository extends JpaRepository<PostModel, Integer> {
}
