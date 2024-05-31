package com.theseus.turnos.servicesimp;


import com.theseus.turnos.dao.IProfesionalesDao;
import com.theseus.turnos.entities.Profesionales;
import com.theseus.turnos.entities.TiposDoc;
import com.theseus.turnos.services.IProfesionalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfesionalesService implements IProfesionalesService {

    @Autowired
    private IProfesionalesDao entityDao;

    public List<Profesionales> getAll() {
        return entityDao.findAll(Sort.by(Sort.Direction.ASC,"apellido"));
    }

    public List<Profesionales> findByApellido(String apellido) {
        return entityDao.findByApellido("%" + apellido + "%");
    }

    public Profesionales getByDoc(TiposDoc tipodoc, String numdoc) {
        List<Profesionales> r = entityDao.getByDoc(tipodoc,numdoc);
        if (r==null) return null;
        else
            return r.get(0);
    }

    public Profesionales get(Integer id) {
        return entityDao.findById(id).orElse(null);
    }

    @Transactional
    public void save(Profesionales entity) {
        entityDao.save(entity);
    }

    @Transactional
    public String delete(Profesionales entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }
}
