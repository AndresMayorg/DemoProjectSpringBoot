package com.project.demo.project.service;

import com.project.demo.project.persistence.entity.ClientEntity;
import com.project.demo.project.persistence.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.BeanPropertyRowMapper;


import java.util.List;

@Service
public class ClientService {
    private final JdbcTemplate jdbcTemplate;
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(JdbcTemplate jdbcTemplate, ClientRepository clientRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.clientRepository = clientRepository;
    }

    public List<ClientEntity> getAllClients() {
        //return this.clientRepository.findAll();
        return this.jdbcTemplate.query("SELECT * FROM clients", new BeanPropertyRowMapper<>(ClientEntity.class));
    }

    public ClientEntity getClientById(int idClient) {
        //return this.clientRepository.findById(idClient).orElse(null);
        return this.jdbcTemplate.queryForObject("SELECT * FROM clients WHERE id_client" +
                " = ?", new Object[]{idClient}, new BeanPropertyRowMapper<>(ClientEntity.class));
    }

    public ClientEntity saveClient(ClientEntity client) {
        return this.clientRepository.save(client);
    }

    public boolean existsClient(int idClient) {
        return this.clientRepository.existsById(idClient);
    }

    public void deleteClient(int idClient) {
        this.clientRepository.deleteById(idClient);
    }
}
