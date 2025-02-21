package com.project.demo.project.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "work_orders")
@Getter
@Setter
@NoArgsConstructor
public class WorkOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_work_order", nullable = false)
    private Integer idWorkOrder;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    @Column(name = "materials", length = 100, nullable = false)
    private String materials;

    @Column(name = "order_number", length = 50, nullable = false)
    private String orderNumber;

    @Column(name = "id_client", nullable = false)
    private Integer idClient;

    @Column(length = 500)
    private String activities;

    @Column(length = 500)
    private String pending;

    // Relación con Client
    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id_client", insertable = false, updatable = false, nullable = false)
    private ClientEntity client;

    // Relación con Photos (1 orden -> muchas fotos)
    @OneToMany(mappedBy = "workOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhotoEntity> photos;

    // Relación many-to-many con Technicians a través de la tabla intermedia
    @OneToMany(mappedBy = "workOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkOrderTechnicianEntity> workOrderTechnicians;

}
