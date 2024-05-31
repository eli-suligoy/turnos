package com.theseus.turnos.dao;


import com.theseus.turnos.entities.Profesionales;
import com.theseus.turnos.entities.TiposDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProfesionalesDao extends JpaRepository<Profesionales, Integer> {
    @Query("select c from Profesionales c where c.apellido like ?1")
    public List<Profesionales> findByApellido(String name);

    @Query("select c from Profesionales c where c.tipodoc = ?1 and c.numdoc = ?2")
    public List<Profesionales> getByDoc(TiposDoc tipodoc, String numdoc);

}
