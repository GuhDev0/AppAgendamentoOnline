package com.AgendamentoOnline.Repository;

import com.AgendamentoOnline.Models.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento,Long> {
}
