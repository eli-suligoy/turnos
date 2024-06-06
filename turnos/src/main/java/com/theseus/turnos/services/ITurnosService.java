package com.theseus.turnos.services;


import com.theseus.turnos.entities.Turnos;

import java.util.List;

public interface ITurnosService {
    List<Turnos> getAll();
    Turnos get(String id);
    void save(Turnos entity);
    String delete(Turnos entity);
}