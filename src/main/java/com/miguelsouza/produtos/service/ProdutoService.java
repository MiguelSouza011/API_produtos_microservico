package com.miguelsouza.produtos.service;

import com.miguelsouza.produtos.dto.ProdutoDTO;
import com.miguelsouza.produtos.dto.ProdutoResponseDTO;
import com.miguelsouza.produtos.exceptions.ResourceNotFoundException;
import com.miguelsouza.produtos.mapper.ProdutoMapper;
import com.miguelsouza.produtos.model.Produto;
import com.miguelsouza.produtos.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;
    private final ProdutoMapper mapper;

    public ProdutoResponseDTO salvar(ProdutoDTO dto) {

        Produto produto = mapper.toEntity(dto);

        produto = repository.save(produto);

        return mapper.toDTO(produto);
    }

    public ProdutoResponseDTO obterPorCodigo(Long codigo) {

        Produto produto = repository.findById(codigo)
                .orElseThrow(() -> new ResourceNotFoundException(codigo));

        return mapper.toDTO(produto);
    }

    public void deletarPorCodigo(Long codigo) {
        obterPorCodigo(codigo);
        repository.deleteById(codigo);
    }

    public List<ProdutoResponseDTO> listarTodos() {

        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public ProdutoResponseDTO update(Long codigo, ProdutoDTO dto) {

        Produto produto = repository.findById(codigo)
                .orElseThrow(() -> new ResourceNotFoundException(codigo));

        produto.setNome(dto.nome());
        produto.setValorUnitario(dto.valorUnitario());

        produto = repository.save(produto);

        return mapper.toDTO(produto);
    }

}
