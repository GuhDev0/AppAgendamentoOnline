package com.AgendamentoOnline.Services;

import com.AgendamentoOnline.Dtos.DtoHorarioDeFuncionamento;
import com.AgendamentoOnline.Models.HorarioDeFuncionamento;
import com.AgendamentoOnline.Models.Profissional;
import com.AgendamentoOnline.Repository.HorarioDeFuncionamentoRepository;
import com.AgendamentoOnline.Repository.ProfissionalRepository;
import org.springframework.stereotype.Service;

@Service
public class HorarioDeFuncionamentoServices {

    private final HorarioDeFuncionamentoRepository horarioDeFuncionamentoRepository;
    private final ProfissionalRepository profissionalRepository;

    public HorarioDeFuncionamentoServices(HorarioDeFuncionamentoRepository horarioDeFuncionamentoRepository, ProfissionalRepository profissionalRepository) {
        this.horarioDeFuncionamentoRepository = horarioDeFuncionamentoRepository;
        this.profissionalRepository = profissionalRepository;
    }

    public HorarioDeFuncionamento saveHorarioDeFuncionamento (DtoHorarioDeFuncionamento dtoHorario){

        Profissional profissional = profissionalRepository.findById(dtoHorario.profissionalId()).
                orElseThrow( () -> new RuntimeException("Profissional nao encontrado"));
        HorarioDeFuncionamento horario = new HorarioDeFuncionamento();
        horario.setInicioDoHorario(dtoHorario.horaDeInicio());
        horario.setFimDoHorario(dtoHorario.horaDeFim());
        horario.setDias(dtoHorario.dias());
        horario.setProfissional(profissional);
        return horarioDeFuncionamentoRepository.save(horario);
    }


}
