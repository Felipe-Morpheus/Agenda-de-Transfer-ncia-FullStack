package com.vulpicula.agenda.de.transferencia.services;
import com.vulpicula.agenda.de.transferencia.models.Transferencia;
import com.vulpicula.agenda.de.transferencia.repositories.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class TransferenciaService {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    public Transferencia agendarTransferencia(Transferencia transferencia) {
        // Calcular a taxa com base na data de transferência
        BigDecimal taxa = calcularTaxa(transferencia.getDataTransferencia(), transferencia.getValor());
        transferencia.setTaxa(taxa);

        // Salvar a transferência
        return transferenciaRepository.save(transferencia);
    }

    public List<Transferencia> listarTransferencias() {
        return transferenciaRepository.findAll();
    }

    private BigDecimal calcularTaxa(LocalDate dataTransferencia, BigDecimal valor) {
        long diasEntre = ChronoUnit.DAYS.between(LocalDate.now(), dataTransferencia);

        if (diasEntre == 0) {
            return valor.multiply(new BigDecimal("0.025")).add(new BigDecimal("3.00"));
        } else if (diasEntre <= 10) {
            return new BigDecimal("12.00");
        } else if (diasEntre <= 20) {
            return valor.multiply(new BigDecimal("0.082"));
        } else if (diasEntre <= 30) {
            return valor.multiply(new BigDecimal("0.069"));
        } else if (diasEntre <= 40) {
            return valor.multiply(new BigDecimal("0.047"));
        } else if (diasEntre <= 50) {
            return valor.multiply(new BigDecimal("0.017"));
        } else {
            throw new IllegalArgumentException("Data de transferência fora do período permitido.");
        }
    }
}

