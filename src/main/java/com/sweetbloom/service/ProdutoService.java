package com.sweetbloom.service;

import com.sweetbloom.ProdutoRequestDTO.ProdutoRequestDTO;
import com.sweetbloom.model.Produto;
import com.sweetbloom.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarTodos(){
        return produtoRepository.findAll();
    }

    public Produto criarProduto(ProdutoRequestDTO dto) {
        Produto produto = Produto.builder()
                .name(dto.name())
                .description(dto.description())
                .price(dto.price())
                .category(dto.category())
                .avaliabe(dto.avaliabe())
                .build();

        return produtoRepository.save(produto);
    }


    public void deletarProduto( Long id){
        produtoRepository.deleteById(id);
    }

}
