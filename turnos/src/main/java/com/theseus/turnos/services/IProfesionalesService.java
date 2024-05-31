package com.theseus.turnos.services;



import com.theseus.turnos.entities.Profesionales;
import com.theseus.turnos.entities.TiposDoc;

import java.util.List;

public interface IProfesionalesService {
    List<Profesionales> getAll();
    List<Profesionales> findByApellido(String apellido);
    Profesionales getByDoc(TiposDoc tipodoc, String numdoc);
    Profesionales get(Integer id);
    void save(Profesionales entity);
    String delete(Profesionales entity);


}
