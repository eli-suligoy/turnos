package com.theseus.turnos.controller;



import com.theseus.turnos.entities.DiasHorariosProfesionales;
import com.theseus.turnos.services.IDiasHorariosProfesionalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DiasHorariosProfesionalesController {

    @Autowired
    IDiasHorariosProfesionalesService entityService;

    @GetMapping(path = "/diashorariosprofesionales")
    public List<DiasHorariosProfesionales> getAll() {return entityService.getAll();}

    @GetMapping(path = "/diashorariosprofesionales/{id}")
    public DiasHorariosProfesionales get(@PathVariable Long id) {return entityService.get(id);}


    @PostMapping(value = "/diashorariosprofesionales", consumes = "application/json", produces = "application/json")
    public DiasHorariosProfesionales save(@RequestBody DiasHorariosProfesionales entity) {
        entityService.save(entity);
        return entity;
    }

    @GetMapping (path = "/diashorariosprofesionales/delete/{id}")
    public String delete(@PathVariable Long id) {
        DiasHorariosProfesionales entity = null;
         try {
             entity = entityService.get(id);
             entityService.delete(entity);
             return null;
         } catch (Exception e) {
             return e.getMessage().toString();
         }
    }

}
