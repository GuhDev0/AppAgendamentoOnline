package com.AgendamentoOnline.Models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "tb_Agendamento")
public class Agendamento {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "data")
    private LocalDate data;
    @Column(name = "hora")
    private LocalTime hora;
    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "Cliente_Id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "Profissional_Id")
    private Profissional profissional ;



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }





}
