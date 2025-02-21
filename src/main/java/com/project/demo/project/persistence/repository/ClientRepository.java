package com.project.demo.project.persistence.repository;


import com.project.demo.project.persistence.entity.ClientEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface ClientRepository extends ListCrudRepository<ClientEntity, Integer> {

}
