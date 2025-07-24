package com.AgendamentoOnline.Services;

import com.AgendamentoOnline.Dtos.DtoProfissional;
import com.AgendamentoOnline.Models.Profissional;
import com.AgendamentoOnline.Repository.ProfissionalRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfissionalServices {

   private final ProfissionalRepository profissionalRepository;


    public ProfissionalServices(ProfissionalRepository profissionalRepository) {
        this.profissionalRepository = profissionalRepository;
    }

    public Profissional saveProfissional(DtoProfissional dtoProfissional) {

        Profissional profissional = new Profissional();
        profissional.setNome(dtoProfissional.nome());
        profissional.setSenha(dtoProfissional.senha());
        profissional.setEmail(dtoProfissional.email());
        profissional.setTelefone(dtoProfissional.telefone());

        return profissionalRepository.save(profissional);
    }
}
