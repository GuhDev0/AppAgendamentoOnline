package com.AgendamentoOnline.Dtos;

import java.time.LocalDate;
import java.time.LocalTime;

public record DtoAgendamento(LocalDate data, String tipoDeServicio, LocalTime hora, Long idCliente ) {

}
