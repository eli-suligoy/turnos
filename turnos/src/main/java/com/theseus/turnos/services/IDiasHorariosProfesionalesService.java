package com.theseus.turnos.services;


import com.theseus.turnos.entities.DiasHorariosProfesionales;

import java.util.List;

public interface IDiasHorariosProfesionalesService {
    List<DiasHorariosProfesionales> getAll();
    DiasHorariosProfesionales get(Long id);
    void save(DiasHorariosProfesionales entity);
    String delete(DiasHorariosProfesionales entity);
}