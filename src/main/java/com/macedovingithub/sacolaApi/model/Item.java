package com.macedovingithub.sacolaApi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@Entity
@JsonIgnoreProperties({"hibernatLazyInitializer", "handler"})
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private Produto produto;
    private int quantidade;
    @ManyToOne
    @JsonIgnore
    private Sacola sacola;
}
