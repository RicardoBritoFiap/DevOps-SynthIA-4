package com.RicardoBritoFiap.SynthAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.RicardoBritoFiap.SynthAPI.model.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}