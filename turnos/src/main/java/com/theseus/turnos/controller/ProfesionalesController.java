package com.theseus.turnos.controller;



import com.theseus.turnos.entities.Profesionales;
import com.theseus.turnos.services.IProfesionalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProfesionalesController {
    @Autowired
    IProfesionalesService entityService;

    @GetMapping(path = "/profesionales")
    public List<Profesionales> getAll() {return entityService.getAll();}

    @GetMapping(path = "/profesionales/{id}")
    public Profesionales get(@PathVariable Integer id) {return entityService.get(id);}

    @GetMapping(path = "/profesionales/search/{expresion}")
    public List<Profesionales> getListProfesionales(@PathVariable String expresion) {return entityService.findByApellido(expresion);}

    @PostMapping(value = "/profesionales", consumes = "application/json", produces = "application/json")
    public Profesionales save(@RequestBody Profesionales entity) {
        entityService.save(entity);
        return entity;
    }

    @GetMapping (path = "/profesionales/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Profesionales entity = null;
        try {
            entity = entityService.get(id);
            entityService.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }
}
