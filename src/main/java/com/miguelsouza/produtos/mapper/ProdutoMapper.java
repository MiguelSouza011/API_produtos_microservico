package com.miguelsouza.produtos.mapper;

import com.miguelsouza.produtos.dto.ProdutoDTO;
import com.miguelsouza.produtos.dto.ProdutoResponseDTO;
import com.miguelsouza.produtos.model.Produto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    Produto toEntity(ProdutoDTO dto);

    ProdutoResponseDTO toDTO(Produto produto);

}
