package com.vulpicula.agenda.de.transferencia.controllers;

import com.vulpicula.agenda.de.transferencia.models.Conta;
import com.vulpicula.agenda.de.transferencia.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @PostMapping
    public ResponseEntity<Conta> criarConta(@RequestBody Conta conta) {
        Conta novaConta = contaService.salvarConta(conta);
        return ResponseEntity.ok(novaConta);

    }
        @GetMapping
        public ResponseEntity<List<Conta>> listarContas() {
            List<Conta> contas = contaService.listarContas();
            return ResponseEntity.ok(contas);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Conta> buscarContaPorId(@PathVariable Long id) {
            return contaService.buscarContaPorId(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }
    }