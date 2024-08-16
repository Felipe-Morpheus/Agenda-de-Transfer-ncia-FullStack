package com.vulpicula.agenda.de.transferencia.repositories;


import com.vulpicula.agenda.de.transferencia.models.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository <Conta, Long> {
}
