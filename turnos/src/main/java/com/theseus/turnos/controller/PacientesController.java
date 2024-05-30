package com.theseus.turnos.controller;



import com.theseus.turnos.entities.Pacientes;
import com.theseus.turnos.services.IPacientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PacientesController {
    @Autowired
    IPacientesService entityService;

    @GetMapping(path = "/pacientes")
    public List<Pacientes> getAll() {return entityService.getAll();}

    @GetMapping(path = "/pacientes/{id}")
    public Pacientes get(@PathVariable Integer id) {return entityService.get(id);}

    @GetMapping(path = "/pacientes/search/{expresion}")
    public List<Pacientes> getListPacientes(@PathVariable String expresion) {return entityService.findByApellido(expresion);}

    @PostMapping(value = "/pacientes", consumes = "application/json", produces = "application/json")
    public Pacientes save(@RequestBody Pacientes entity) {
        entityService.save(entity);
        return entity;
    }

    @GetMapping (path = "/pacientes/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Pacientes entity = null;
        try {
            entity = entityService.get(id);
            entityService.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }
}
