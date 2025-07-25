package com.AgendamentoOnline.Models;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "db_HorarioDeFuncionamento")
public class HorarioDeFuncionamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "inicio_do_horario", nullable = false)
    private LocalTime inicioDoHorario;

    @Column(name = "fim_do_horario", nullable = false)
    private LocalTime fimDoHorario;

    @Column(name = "dias", nullable = false)
    private String dias;

    @ManyToOne
    @JoinColumn(name = "profissional_id", nullable = false)
    private Profissional profissional;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getInicioDoHorario() {
        return inicioDoHorario;
    }

    public void setInicioDoHorario(LocalTime inicioDoHorario) {
        this.inicioDoHorario = inicioDoHorario;
    }

    public LocalTime getFimDoHorario() {
        return fimDoHorario;
    }

    public void setFimDoHorario(LocalTime fimDoHorario) {
        this.fimDoHorario = fimDoHorario;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }


}
