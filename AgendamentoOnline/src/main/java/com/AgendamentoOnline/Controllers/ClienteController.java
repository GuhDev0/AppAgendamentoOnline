package com.AgendamentoOnline.Controllers;

import com.AgendamentoOnline.Dtos.DtoCliente;
import com.AgendamentoOnline.Dtos.ResponseRequest;
import com.AgendamentoOnline.Models.Cliente;
import com.AgendamentoOnline.Services.ClienteServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Cliente")
public class ClienteController {

    private final ClienteServices clienteServices;

    public ClienteController(ClienteServices clienteServices) {
        this.clienteServices = clienteServices;
    }

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody DtoCliente dtoCliente){
        return  ResponseEntity.status(HttpStatus.CREATED).body(clienteServices.saveRepository(dtoCliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseRequest> delete(@PathVariable Long id){
        clienteServices.deleteRepository(id);
        return ResponseEntity.ok(new ResponseRequest("Cliente Deletado com Sucesso", "204"));
    }
}
