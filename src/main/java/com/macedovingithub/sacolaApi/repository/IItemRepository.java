package com.macedovingithub.sacolaApi.repository;

import com.macedovingithub.sacolaApi.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IItemRepository extends JpaRepository<Item, Long>{
}
