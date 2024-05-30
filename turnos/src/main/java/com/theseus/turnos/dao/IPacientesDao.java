package com.theseus.turnos.dao;


import com.theseus.turnos.entities.Pacientes;
import com.theseus.turnos.entities.TiposDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPacientesDao extends JpaRepository<Pacientes, Integer> {
    @Query("select c from Pacientes c where c.apellido like ?1")
    public List<Pacientes> findByApellido(String name);

    @Query("select c from Pacientes c where c.tipodoc = ?1 and c.numdoc = ?2")
    public List<Pacientes> getByDoc(TiposDoc tipodoc, String numdoc);

}
