package com.theseus.turnos.controller;



import com.theseus.turnos.entities.DiasHorariosTurnos;
import com.theseus.turnos.services.IDiasHorariosTurnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DiasHorariosTurnosController {

    @Autowired
    IDiasHorariosTurnosService entityService;

    @GetMapping(path = "/diashorariosturnos")
    public List<DiasHorariosTurnos> getAll() {return entityService.getAll();}

    @GetMapping(path = "/diashorariosturnos/{id}")
    public DiasHorariosTurnos get(@PathVariable Long id) {return entityService.get(id);}


    @PostMapping(value = "/diashorariosturnos", consumes = "application/json", produces = "application/json")
    public DiasHorariosTurnos save(@RequestBody DiasHorariosTurnos entity) {
        entityService.save(entity);
        return entity;
    }

    @GetMapping (path = "/diashorariosturnos/delete/{id}")
    public String delete(@PathVariable Long id) {
        DiasHorariosTurnos entity = null;
         try {
             entity = entityService.get(id);
             entityService.delete(entity);
             return null;
         } catch (Exception e) {
             return e.getMessage().toString();
         }
    }

}
