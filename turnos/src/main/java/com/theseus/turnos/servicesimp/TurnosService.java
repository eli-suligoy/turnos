package com.theseus.turnos.servicesimp;


import com.theseus.turnos.dao.ITurnosDao;
import com.theseus.turnos.entities.Turnos;
import com.theseus.turnos.services.ITurnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TurnosService implements ITurnosService {
    @Autowired
    private ITurnosDao entityDao;

    public List<Turnos> getAll() {
        return entityDao.findAll(Sort.by(Sort.Direction.ASC,"descrip"));
    }


    public Turnos get(String id) {
        return entityDao.findById(id).orElse(null);
    }

    @Transactional
    public void save(Turnos entity) {
                entityDao.save(entity);
    }

    @Transactional
    public String delete(Turnos entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }

    }
}