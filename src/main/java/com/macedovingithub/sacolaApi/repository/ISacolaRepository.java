package com.macedovingithub.sacolaApi.repository;

import com.macedovingithub.sacolaApi.model.Sacola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISacolaRepository extends JpaRepository<Sacola, Long> {
}
