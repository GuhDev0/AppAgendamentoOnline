package com.AgendamentoOnline.Dtos;

import com.AgendamentoOnline.Models.Profissional;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record DtoAgendamento(
        @NotNull(message = "Campo Obrigatorio ")
        LocalDate data,
        @NotBlank(message = "Obrigatorio digita o tipo de serviço")
        String tipoDeServicio,
        @NotBlank(message = "Campo Obrigatorio")
        String profissional ,
        @NotNull(message = "Campo Obrigatorio")
        LocalTime hora,
        @NotNull
        Long idCliente ) {

}
