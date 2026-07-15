package com.sweetbloom.controller;

import com.sweetbloom.ProdutoRequestDTO.ProdutoRequestDTO;
import com.sweetbloom.model.Produto;
import com.sweetbloom.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> listar(){
        return produtoService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Produto> criarProdutos(@Valid @RequestBody ProdutoRequestDTO dto){
        Produto salvar = produtoService.criarProduto(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Produto> deletarProdutos(@PathVariable Long id){
        produtoService.deletarProduto(id);

        return ResponseEntity.noContent().build();
    }

}
