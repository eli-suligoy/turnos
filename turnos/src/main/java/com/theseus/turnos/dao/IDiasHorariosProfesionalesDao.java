package com.theseus.turnos.dao;


import com.theseus.turnos.entities.DiasHorariosProfesionales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDiasHorariosProfesionalesDao extends JpaRepository<DiasHorariosProfesionales, Long> {

}
