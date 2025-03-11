package com.project.demo.project.web.controller;

import com.project.demo.project.persistence.entity.ClientEntity;
import com.project.demo.project.persistence.entity.TechnicianEntity;
import com.project.demo.project.service.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technicians")
public class TechnicianController {
    private final TechnicianService technicianService;

    @Autowired
    public TechnicianController(TechnicianService technicianService) {
        this.technicianService = technicianService;
    }

    @GetMapping
    public ResponseEntity<List<TechnicianEntity>> getAllTechnicians() {
        return ResponseEntity.ok(this.technicianService.getAllTechnicians());
    }

    @GetMapping("/{idTechnician}")
    public ResponseEntity<TechnicianEntity> getTechnicianById(@PathVariable int idTechnician) {
        return ResponseEntity.ok(this.technicianService.getTechnicianById(idTechnician));
    }

   @PostMapping
   public ResponseEntity<TechnicianEntity> saveTechnician(@RequestBody TechnicianEntity technician) {
       if (technician.getIdTechnician() == null || !this.technicianService.existsTechnicianById(technician.getIdTechnician())) {
           return ResponseEntity.ok(this.technicianService.saveTechnician(technician));
       } else {
           return ResponseEntity.badRequest().build();
       }
   }

   @PutMapping
    public ResponseEntity<TechnicianEntity> updateTechnician(@RequestBody TechnicianEntity technician) {
         if (technician.getIdTechnician() != null && this.technicianService.existsTechnicianById(technician.getIdTechnician())) {
              return ResponseEntity.ok(this.technicianService.saveTechnician(technician));
         } else {
              return ResponseEntity.badRequest().build();
         }
    }

    @DeleteMapping("/{idTechnician}")
    public ResponseEntity<Void> deleteTechnician(@PathVariable int idTechnician) {
        if (this.technicianService.existsTechnicianById(idTechnician)) {
            this.technicianService.deleteTechnician(idTechnician);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


}
