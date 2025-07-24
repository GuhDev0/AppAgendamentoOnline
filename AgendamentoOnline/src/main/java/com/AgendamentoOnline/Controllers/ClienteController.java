package com.AgendamentoOnline.Controllers;

import com.AgendamentoOnline.Dtos.DtoAgendamento;
import com.AgendamentoOnline.Dtos.DtoCliente;
import com.AgendamentoOnline.Dtos.DtoProfissional;
import com.AgendamentoOnline.Dtos.ResponseRequest;
import com.AgendamentoOnline.Models.Agendamento;
import com.AgendamentoOnline.Models.Cliente;
import com.AgendamentoOnline.Models.Profissional;
import com.AgendamentoOnline.Services.AgendamentoServices;
import com.AgendamentoOnline.Services.ClienteServices;
import com.AgendamentoOnline.Services.ProfissionalServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/agendamentoOnline")
public class ClienteController {

    private final ClienteServices clienteServices;
    private final AgendamentoServices agendamentoServices;
    private final ProfissionalServices profissionalServices;

    public ClienteController(ClienteServices clienteServices, AgendamentoServices agendamentoServices, ProfissionalServices profissionalServices) {
        this.clienteServices = clienteServices;
        this.agendamentoServices = agendamentoServices;
        this.profissionalServices = profissionalServices;
    }

    @PostMapping("/registrarCliente")
    public ResponseEntity<Cliente> save(@RequestBody DtoCliente dtoCliente){
        return  ResponseEntity.status(HttpStatus.CREATED).body(clienteServices.saveRepository(dtoCliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseRequest> delete(@PathVariable Long id){
        clienteServices.deleteRepository(id);
        return ResponseEntity.ok(new ResponseRequest("Cliente Deletado com Sucesso", "204"));
    }
    @PostMapping("/Agendamento")
    public ResponseEntity<ResponseRequest> saveAgendamento(@RequestBody DtoAgendamento dtoAgendamento){
        agendamentoServices.novoAgendamento(dtoAgendamento);
        return ResponseEntity.ok(new ResponseRequest("Agendamento Marcado","200"));
    }

    @PostMapping("/registerProfissional")
    public ResponseEntity<Profissional> saveProfissional(@RequestBody DtoProfissional dtoProfissional){
        return ResponseEntity.status(HttpStatus.CREATED).body(profissionalServices.saveProfissional(dtoProfissional));
    }
}
