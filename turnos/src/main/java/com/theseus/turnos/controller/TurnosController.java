package com.theseus.turnos.controller;



import com.theseus.turnos.entities.Turnos;
import com.theseus.turnos.services.ITurnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TurnosController {

    @Autowired
    ITurnosService entityService;

    @GetMapping(path = "/turnos")
    public List<Turnos> getAll() {return entityService.getAll();}

    @GetMapping(path = "/turnos/{id}")
    public Turnos get(@PathVariable String id) {return entityService.get(id);}


    @PostMapping(value = "/turnos", consumes = "application/json", produces = "application/json")
    public Turnos save(@RequestBody Turnos entity) {
        entityService.save(entity);
        return entity;
    }

    @GetMapping (path = "/turnos/delete/{id}")
    public String delete(@PathVariable String id) {
        Turnos entity = null;
         try {
             entity = entityService.get(id);
             entityService.delete(entity);
             return null;
         } catch (Exception e) {
             return e.getMessage().toString();
         }
    }

}
