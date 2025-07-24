package com.AgendamentoOnline.Services;

import com.AgendamentoOnline.Dtos.DtoAgendamento;
import com.AgendamentoOnline.Models.Agendamento;
import com.AgendamentoOnline.Models.Cliente;
import com.AgendamentoOnline.Repository.AgendamentoRepository;
import com.AgendamentoOnline.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgendamentoServices {


    private  final AgendamentoRepository agendamento;
    private final ClienteRepository clienteRepository;

    public AgendamentoServices(AgendamentoRepository agendamento, ClienteRepository clienteRepository) {
        this.agendamento = agendamento;
        this.clienteRepository = clienteRepository;
    }

   public Agendamento novoAgendamento(DtoAgendamento request){
     Agendamento novo = new Agendamento();
     Cliente cliente = clienteRepository.findById(request.idCliente())
             .orElseThrow(() -> new RuntimeException("Cliente nao encontrado"));
     novo.setCliente(cliente);
     novo.setHora(request.hora());
     novo.setData(request.data());
     novo.setTipoDeServicio(request.tipoDeServicio());
     return agendamento.save(novo);
   }
}
