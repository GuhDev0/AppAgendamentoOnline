package com.AgendamentoOnline.Services;

import com.AgendamentoOnline.Dtos.DtoCliente;
import com.AgendamentoOnline.Models.Cliente;
import com.AgendamentoOnline.Repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ClienteServices {

    private final ClienteRepository clienteRepository;



    public ClienteServices(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    @Transactional
    public Cliente saveRepository(DtoCliente dtoCliente) {

        Cliente cliente = new Cliente();
        cliente.setNome(dtoCliente.nome());
        cliente.setTelefone(dtoCliente.telefone());
        cliente.setEmail(dtoCliente.email());
        cliente.setSenha(dtoCliente.senha());

        return clienteRepository.save(cliente);
    }

    public void deleteRepository( Long id) {
        clienteRepository.deleteById(id);
    }

}

