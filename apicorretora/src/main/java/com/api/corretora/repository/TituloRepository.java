package com.api.corretora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.corretora.datasource.model.Titulo;

@Repository
public interface TituloRepository extends JpaRepository<Titulo, Long> {
    List<Titulo> findAll();
}

