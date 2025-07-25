package com.AgendamentoOnline.Dtos;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.DayOfWeek;
import java.time.LocalTime;

public record DtoHorarioDeFuncionamento(
        @JsonFormat(pattern = "HH:mm")
        LocalTime horaDeInicio,
        @JsonFormat(pattern = "HH:mm")
        LocalTime horaDeFim,
        String dias,
        Long profissionalId
) {
}
