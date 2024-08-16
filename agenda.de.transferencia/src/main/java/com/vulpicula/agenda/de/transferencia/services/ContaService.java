package com.vulpicula.agenda.de.transferencia.services;

import com.vulpicula.agenda.de.transferencia.models.Conta;
import com.vulpicula.agenda.de.transferencia.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public Conta salvarConta(Conta conta) {
        return contaRepository.save(conta);
    }

    public List<Conta> listarContas() {
        return contaRepository.findAll();
    }

    public Optional<Conta> buscarContaPorId(Long id) {
        return contaRepository.findById(id);
    }
}
