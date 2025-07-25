package com.AgendamentoOnline.Services;

import com.AgendamentoOnline.Dtos.DtoAgendamento;
import com.AgendamentoOnline.Models.Agendamento;
import com.AgendamentoOnline.Models.Cliente;
import com.AgendamentoOnline.Models.Profissional;
import com.AgendamentoOnline.Repository.AgendamentoRepository;
import com.AgendamentoOnline.Repository.ClienteRepository;
import com.AgendamentoOnline.Repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgendamentoServices {


    private  final AgendamentoRepository agendamento;
    private final ClienteRepository clienteRepository;
    private final ProfissionalRepository profissionalRepository;

    public AgendamentoServices(AgendamentoRepository agendamento, ClienteRepository clienteRepository, ProfissionalRepository profissionalRepository) {
        this.agendamento = agendamento;
        this.clienteRepository = clienteRepository;
        this.profissionalRepository = profissionalRepository;
    }

   public Agendamento novoAgendamento(DtoAgendamento request){
     Agendamento novo = new Agendamento();
     Profissional profissional = profissionalRepository.findByNome(request.profissional());
     Cliente cliente = clienteRepository.findById(request.idCliente())
             .orElseThrow(() -> new RuntimeException("Cliente nao encontrado"));
     if(profissional == null){
         throw new RuntimeException("Profissional nao encontrado");
     }

        boolean horarioOcupado = agendamento.existsByProfissionalAndHoraAndData(profissional,request.hora(), request.data());
       if(horarioOcupado){
         throw new RuntimeException("Horario ocupado");
     }
       novo.setCliente(cliente);
     novo.setHora(request.hora());
     novo.setData(request.data());
     novo.setProfissional(profissional);
     novo.setTipoDeServicio(request.tipoDeServicio());
     return agendamento.save(novo);
   }
}
