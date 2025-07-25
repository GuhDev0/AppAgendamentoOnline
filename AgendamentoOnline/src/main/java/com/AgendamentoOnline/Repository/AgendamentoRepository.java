package com.AgendamentoOnline.Repository;

import com.AgendamentoOnline.Models.Agendamento;
import com.AgendamentoOnline.Models.Cliente;
import com.AgendamentoOnline.Models.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento,Long> {

    Boolean existsByProfissionalAndHoraAndData(Profissional profissional, LocalTime hora, LocalDate data);
}
