package com.miguelsouza.produtos.controller;

import com.miguelsouza.produtos.dto.ProdutoDTO;
import com.miguelsouza.produtos.dto.ProdutoResponseDTO;
import com.miguelsouza.produtos.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("produtos")
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> salvar(
            @RequestBody ProdutoDTO dto) {

        return ResponseEntity.ok(service.salvar(dto));
    }

    @GetMapping("{codigo}")
    public ResponseEntity<ProdutoResponseDTO> obterPorCodigo(
            @PathVariable Long codigo) {
        return ResponseEntity.ok(service.obterPorCodigo(codigo));
    }

    @DeleteMapping("{codigo}")
    public ResponseEntity<Void> deletarPorCodigo(@PathVariable Long codigo) {
        service.deletarPorCodigo(codigo);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> listarTodos() {

        return ResponseEntity.ok(service.listarTodos());
    }

    @PutMapping("{codigo}")
    public ResponseEntity<ProdutoResponseDTO> atualizar(
            @PathVariable Long codigo,
            @RequestBody ProdutoDTO dto) {

        return ResponseEntity.ok(service.update(codigo, dto));
    }
}
