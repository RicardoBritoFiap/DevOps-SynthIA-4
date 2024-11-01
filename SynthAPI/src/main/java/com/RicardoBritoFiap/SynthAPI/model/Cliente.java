package com.RicardoBritoFiap.SynthAPI.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq_gen")
    @SequenceGenerator(name = "cliente_seq_gen", sequenceName = "cliente_seq", allocationSize = 1)
    private Long id;

    @NotBlank
    private String cpf;

    @NotBlank
    private String nome;

    @NotBlank
    private String email;

    @NotBlank
    private String algoritmo;

    @NotBlank
    private String modelo;
}