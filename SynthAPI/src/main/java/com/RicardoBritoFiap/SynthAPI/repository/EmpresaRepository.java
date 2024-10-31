package com.RicardoBritoFiap.SynthAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.RicardoBritoFiap.SynthAPI.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}