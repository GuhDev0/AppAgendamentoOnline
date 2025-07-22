package com.AgendamentoOnline.Repository;

import com.AgendamentoOnline.Models.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfissionalRepository  extends JpaRepository<Profissional,Long> {
}
