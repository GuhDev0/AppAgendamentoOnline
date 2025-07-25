package com.AgendamentoOnline.Controllers;

import com.AgendamentoOnline.Dtos.*;
import com.AgendamentoOnline.Models.Agendamento;
import com.AgendamentoOnline.Models.Cliente;
import com.AgendamentoOnline.Models.HorarioDeFuncionamento;
import com.AgendamentoOnline.Models.Profissional;
import com.AgendamentoOnline.Services.AgendamentoServices;
import com.AgendamentoOnline.Services.ClienteServices;
import com.AgendamentoOnline.Services.HorarioDeFuncionamentoServices;
import com.AgendamentoOnline.Services.ProfissionalServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/agendamentoOnline")
public class ClienteController {

    private final ClienteServices clienteServices;
    private final AgendamentoServices agendamentoServices;
    private final ProfissionalServices profissionalServices;
    private final HorarioDeFuncionamentoServices horarioDeFuncionamentoServices;
    public ClienteController(ClienteServices clienteServices, AgendamentoServices agendamentoServices, ProfissionalServices profissionalServices, HorarioDeFuncionamentoServices horarioDeFuncionamentoServices) {
        this.clienteServices = clienteServices;
        this.agendamentoServices = agendamentoServices;
        this.profissionalServices = profissionalServices;
        this.horarioDeFuncionamentoServices = horarioDeFuncionamentoServices;
    }

    @PostMapping("/registrarCliente")
    public ResponseEntity<Cliente> save(@RequestBody @Valid DtoCliente dtoCliente){
        return  ResponseEntity.status(HttpStatus.CREATED).body(clienteServices.saveRepository(dtoCliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseRequest> delete(@PathVariable Long id){
        clienteServices.deleteRepository(id);
        return ResponseEntity.ok(new ResponseRequest("Cliente Deletado com Sucesso", "204"));
    }
    @PostMapping("/Agendamento")
    public ResponseEntity<ResponseRequest> saveAgendamento( @RequestBody @Valid DtoAgendamento dtoAgendamento){
        agendamentoServices.novoAgendamento(dtoAgendamento);
        return ResponseEntity.ok(new ResponseRequest("Agendamento Marcado","200"));
    }

    @PostMapping("/registerProfissional")
    public ResponseEntity<Profissional> saveProfissional(@RequestBody @Valid DtoProfissional dtoProfissional){
        return ResponseEntity.status(HttpStatus.CREATED).body(profissionalServices.saveProfissional(dtoProfissional));
    }
    @PostMapping("/HorarioDeFuncionamento")
    public ResponseEntity<HorarioDeFuncionamento> saveHorarioDeFuncionario(@RequestBody  DtoHorarioDeFuncionamento dtoHorario){


        return ResponseEntity.status(HttpStatus.CREATED).body(horarioDeFuncionamentoServices.saveHorarioDeFuncionamento(dtoHorario));
    }
}
