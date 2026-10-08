package com.miguelsouza.produtos.dto;

import java.math.BigDecimal;

public record ProdutoResponseDTO(
        Long codigo,
        String nome,
        BigDecimal valorUnitario
) {
}
