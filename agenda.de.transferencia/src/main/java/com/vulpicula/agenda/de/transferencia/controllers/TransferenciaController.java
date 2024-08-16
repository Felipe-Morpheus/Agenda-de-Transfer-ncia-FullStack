package com.vulpicula.agenda.de.transferencia.controllers;

import com.vulpicula.agenda.de.transferencia.models.Transferencia;
import com.vulpicula.agenda.de.transferencia.services.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

    @Autowired
    private TransferenciaService transferenciaService;

    @PostMapping
    public ResponseEntity<Transferencia> agendarTransferencia(@RequestBody Transferencia transferencia) {
        Transferencia novaTransferencia = transferenciaService.agendarTransferencia(transferencia);
        return ResponseEntity.ok(novaTransferencia);
    }

    @GetMapping
    public ResponseEntity<List<Transferencia>> listarTransferencias() {
        List<Transferencia> transferencias = transferenciaService.listarTransferencias();
        return ResponseEntity.ok(transferencias);
    }
}
