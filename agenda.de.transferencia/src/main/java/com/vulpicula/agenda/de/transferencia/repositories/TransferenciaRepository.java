package com.vulpicula.agenda.de.transferencia.repositories;

import com.vulpicula.agenda.de.transferencia.models.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
}
