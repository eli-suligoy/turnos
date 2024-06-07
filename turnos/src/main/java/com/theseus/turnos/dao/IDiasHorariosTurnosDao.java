package com.theseus.turnos.dao;


import com.theseus.turnos.entities.DiasHorariosTurnos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IDiasHorariosTurnosDao extends JpaRepository<DiasHorariosTurnos, Long> {

}
