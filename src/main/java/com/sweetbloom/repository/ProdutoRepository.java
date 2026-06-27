package com.sweetbloom.repository;

import com.sweetbloom.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    boolean existsById(Long id);
}
