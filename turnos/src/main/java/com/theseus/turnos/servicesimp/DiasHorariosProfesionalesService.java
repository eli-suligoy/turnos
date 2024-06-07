package com.theseus.turnos.servicesimp;


import com.theseus.turnos.dao.IDiasHorariosProfesionalesDao;
import com.theseus.turnos.entities.DiasHorariosProfesionales;
import com.theseus.turnos.services.IDiasHorariosProfesionalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DiasHorariosProfesionalesService implements IDiasHorariosProfesionalesService {
    @Autowired
    private IDiasHorariosProfesionalesDao entityDao;

    public List<DiasHorariosProfesionales> getAll() {
        return entityDao.findAll(Sort.by(Sort.Direction.ASC,"id"));
    }


    public DiasHorariosProfesionales get(Long id) {
        return entityDao.findById(id).orElse(null);
    }

    @Transactional
    public void save(DiasHorariosProfesionales entity) {
        entity.setId(Long.parseLong(entity.getDia().getId().toString()+entity.getHorario().getId().toString()+entity.getProfesional().getId().toString()));
        entityDao.save(entity);
    }

    @Transactional
    public String delete(DiasHorariosProfesionales entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }

    }
}