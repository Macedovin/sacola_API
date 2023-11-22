package com.macedovingithub.sacolaApi.repository;

import com.macedovingithub.sacolaApi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProdutoRepository extends JpaRepository<Produto, Long> {
}
