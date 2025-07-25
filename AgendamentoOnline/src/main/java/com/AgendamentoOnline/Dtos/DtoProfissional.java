package com.AgendamentoOnline.Dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DtoProfissional(
        @NotBlank
        String nome,
         @NotBlank(message = "Campo Obrigatorio")
         String telefone,
        @Size(min = 8, max = 18)
        String senha,
        @Email @NotBlank(message = "Campo Obrigatorio")
         String email) {
}
