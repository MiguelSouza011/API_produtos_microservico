package com.miguelsouza.produtos.dto;

import java.math.BigDecimal;

public record ProdutoDTO(
        String nome,
        BigDecimal valorUnitario
) {
}
