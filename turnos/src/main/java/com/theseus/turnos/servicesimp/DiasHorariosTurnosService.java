package com.theseus.turnos.servicesimp;


import com.theseus.turnos.dao.IDiasHorariosTurnosDao;
import com.theseus.turnos.entities.DiasHorariosTurnos;
import com.theseus.turnos.services.IDiasHorariosTurnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DiasHorariosTurnosService implements IDiasHorariosTurnosService {
    @Autowired
    private IDiasHorariosTurnosDao entityDao;

    public List<DiasHorariosTurnos> getAll() {
        return entityDao.findAll(Sort.by(Sort.Direction.ASC,"descrip"));
    }


    public DiasHorariosTurnos get(Long id) {
        return entityDao.findById(id).orElse(null);
    }

    @Transactional
    public void save(DiasHorariosTurnos entity) {
        entity.setId(Long.parseLong(entity.getDia().getId().toString()+entity.getHorario().getId().toString()));
        entityDao.save(entity);
    }

    @Transactional
    public String delete(DiasHorariosTurnos entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }

    }
}