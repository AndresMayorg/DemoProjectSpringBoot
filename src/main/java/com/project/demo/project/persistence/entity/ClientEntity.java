package com.project.demo.project.persistence.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client", nullable = false)
    private Integer idClient;

    @Column(name = "address", length = 150, nullable = false)
    private String address;

    @Column(name = "location", length = 150, nullable = false)
    private String location;

    @Column(name = "phone", length = 30, nullable = false)
    private String phone;

    @Column(name = "name", length = 30, nullable = false)
    private String name;

    // Relación con WorkOrders (1 cliente -> muchas órdenes)
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkOrderEntity> workOrders;


}
