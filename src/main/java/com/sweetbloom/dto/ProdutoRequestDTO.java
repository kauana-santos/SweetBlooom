package com.sweetbloom.dto;

import com.sweetbloom.model.Category;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;


public record ProdutoRequestDTO(

        @NotNull(message = "O nome do produto é obrigatório")
        String name,

        String description,

        @NotNull(message = "O preço é obrigatório")
        BigDecimal price,

        @NotNull(message = "A categoria é obrigatória")
        Category category,

        @NotNull(message = "Disponibilidade é obrigatorio")
        Boolean avaliabe) {
}
