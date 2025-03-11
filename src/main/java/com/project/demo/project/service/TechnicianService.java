package com.project.demo.project.service;


import com.project.demo.project.persistence.entity.ClientEntity;
import com.project.demo.project.persistence.entity.TechnicianEntity;
import com.project.demo.project.persistence.repository.ClientRepository;
import com.project.demo.project.persistence.repository.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicianService {
    private final JdbcTemplate jdbcTemplate;
    private final TechnicianRepository technicianRepository;

    @Autowired
    public TechnicianService(JdbcTemplate jdbcTemplate, ClientRepository clientRepository, TechnicianRepository technicianRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.technicianRepository = technicianRepository;
    }

    public List<TechnicianEntity> getAllTechnicians() {
        return this.technicianRepository.findAll();
    }

    public TechnicianEntity getTechnicianById(int idTechnician) {
        return this.technicianRepository.findById(idTechnician).orElse(null);
    }

    public TechnicianEntity saveTechnician(TechnicianEntity technician) {
        return this.technicianRepository.save(technician);
    }

    public boolean existsTechnicianById(int idTechnician) {
        return this.technicianRepository.existsById(idTechnician);
    }

    public void deleteTechnician(int idTechnician) {
        this.technicianRepository.deleteById(idTechnician);
    }
}
