package com.vulpicula.agenda.de.transferencia.services;

import com.vulpicula.agenda.de.transferencia.models.Conta;
import com.vulpicula.agenda.de.transferencia.models.Transferencia;
import com.vulpicula.agenda.de.transferencia.repositories.TransferenciaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TransferenciaServiceTest {

    @Mock
    private TransferenciaRepository transferenciaRepository;

    @InjectMocks
    private TransferenciaService transferenciaService;

    public TransferenciaServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAgendarTransferencia() {
        // Setup
        Conta contaOrigem = new Conta(1L, "1234567890");
        Conta contaDestino = new Conta(2L, "0987654321");
        Transferencia transferencia = new Transferencia();
        transferencia.setContaOrigem(contaOrigem);
        transferencia.setContaDestino(contaDestino);
        transferencia.setValor(new BigDecimal("100.00"));
        transferencia.setDataTransferencia(LocalDate.now().plusDays(5));
        transferencia.setDataAgendamento(LocalDate.now());

        BigDecimal taxaEsperada = new BigDecimal("82.00");
        when(transferenciaRepository.save(transferencia)).thenReturn(transferencia);

        // Executa
        Transferencia resultado = transferenciaService.agendarTransferencia(transferencia);

        // Verifica
        assertEquals(taxaEsperada, resultado.getTaxa());
    }

}