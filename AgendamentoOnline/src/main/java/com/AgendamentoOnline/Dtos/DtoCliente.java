package com.AgendamentoOnline.Dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalTime;

public record DtoCliente (
                            @NotBlank(message = "Campo Obrigatorio ")
                            String nome,
                           @NotBlank(message = "Campo Obrigatorio ")
                          String telefone,
                          @Email @NotBlank(message = "Campo Obrigatorio ")
                          String email,
                          @NotBlank(message = "Campo Obrigatorio ") @Size(min = 8, max = 18)
                          String senha) {


}
