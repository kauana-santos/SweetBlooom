package com.sweetbloom.service;

import com.sweetbloom.dto.ProdutoRequestDTO;
import com.sweetbloom.exception.ProdutoNotFoundException;
import com.sweetbloom.model.Produto;
import com.sweetbloom.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarTodos(){
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id){
        return produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException());
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
        if(!produtoRepository.existsById(id)){
            throw new ProdutoNotFoundException();
        }
        produtoRepository.deleteById(id);
    }

    public Produto atualizarProduto(Long id, ProdutoRequestDTO dto){
        Produto produto = buscarPorId(id);

        produto.setName(dto.name());
        produto.setDescription(dto.description());
        produto.setPrice(dto.price());
        produto.setCategory(dto.category());
        produto.setAvaliabe(dto.avaliabe());

        return produtoRepository.save(produto);

    }

}
