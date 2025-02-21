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
@Table(name = "photos")
@Getter
@Setter
@NoArgsConstructor
public class PhotoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_photo", nullable = false)
    private Integer idPhoto;

    @Column(name = "filename", length = 100, nullable = false)
    private String filename;

    @Column(name = "path", length = 200, nullable = false)
    private String path;

    // Relación con WorkOrder (muchas fotos -> 1 orden)
    @ManyToOne
    @JoinColumn(name = "id_work_order", nullable = false)
    private WorkOrderEntity workOrder;
}
