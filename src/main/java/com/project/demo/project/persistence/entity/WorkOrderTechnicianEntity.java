package com.project.demo.project.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "work_orders_technicians")
@Getter
@Setter
@NoArgsConstructor
public class WorkOrderTechnicianEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_work_order_technician")
    private Integer idWorkOrderTechnician;

    @ManyToOne
    @JoinColumn(name = "id_work_order", nullable = false)
    private WorkOrderEntity workOrder;

    @ManyToOne
    @JoinColumn(name = "id_technician", nullable = false)
    private TechnicianEntity technician;
}
