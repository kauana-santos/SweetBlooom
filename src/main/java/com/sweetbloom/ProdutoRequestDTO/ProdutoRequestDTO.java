package com.sweetbloom.ProdutoRequestDTO;

import com.sweetbloom.model.Category;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;


public record ProdutoRequestDTO(

        @NotNull(message = "O nome do produto é obrigatório")
        String name,

        String description,

        @NotBlank(message = "O preço é obrigatório")
        BigDecimal price,

        @NotNull(message = "A categoria é obrigatória")
        Category category,

        @NotNull(message = "Disponibilidade é obrigatorio")
        Boolean avaliabe) {
}
