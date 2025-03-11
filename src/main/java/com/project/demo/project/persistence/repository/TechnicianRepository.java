package com.project.demo.project.persistence.repository;

import com.project.demo.project.persistence.entity.TechnicianEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface TechnicianRepository extends ListCrudRepository<TechnicianEntity,Integer> {
}
