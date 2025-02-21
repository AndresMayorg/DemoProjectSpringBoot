package com.project.demo.project.persistence.repository;

import com.project.demo.project.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, String> {

}
