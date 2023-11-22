package com.macedovingithub.sacolaApi.repository;

import com.macedovingithub.sacolaApi.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRestauranteRepsitory extends JpaRepository<Restaurante, Long> {
}
