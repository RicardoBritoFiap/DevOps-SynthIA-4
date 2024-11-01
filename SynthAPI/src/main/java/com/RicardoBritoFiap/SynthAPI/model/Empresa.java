package com.RicardoBritoFiap.SynthAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empresa_seq_gen")
    @SequenceGenerator(name = "empresa_seq_gen", sequenceName = "empresa_seq", allocationSize = 1)
    private Long id;

    @NotBlank
    private String cnpj;

    @NotBlank
    private String nome;

    @NotBlank
    private String endereço;

    @NotBlank
    private String email;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}