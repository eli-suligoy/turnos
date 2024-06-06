package com.theseus.turnos.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="turnos")
public class Turnos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private LocalDate fecha;
    private Boolean estado;

    @JoinColumn (name = "fk_diashorariosturnos", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private DiasHorariosTurnos diahorario;

    @JoinColumn (name = "fk_profesionales", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private Profesionales profesional;

    @JoinColumn (name = "fk_pacientes", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private Pacientes paciente;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public DiasHorariosTurnos getDiahorario() {
        return diahorario;
    }

    public void setDiahorario(DiasHorariosTurnos diahorario) {
        this.diahorario = diahorario;
    }

    public Profesionales getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesionales profesional) {
        this.profesional = profesional;
    }

    public Pacientes getPaciente() {
        return paciente;
    }

    public void setPaciente(Pacientes paciente) {
        this.paciente = paciente;
    }
}
