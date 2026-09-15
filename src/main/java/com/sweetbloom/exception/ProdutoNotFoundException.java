package com.sweetbloom.exception;

public class ProdutoNotFoundException extends RuntimeException {
    public ProdutoNotFoundException( ) {
        super("Produto não encontrado.");
    }
}
