package com.theseus.turnos.services;



import com.theseus.turnos.entities.Pacientes;
import com.theseus.turnos.entities.TiposDoc;

import java.util.List;

public interface IPacientesService {
    List<Pacientes> getAll();
    List<Pacientes> findByApellido(String apellido);
    Pacientes getByDoc(TiposDoc tipodoc, String numdoc);
    Pacientes get(Integer id);
    void save(Pacientes entity);
    String delete(Pacientes entity);


}
