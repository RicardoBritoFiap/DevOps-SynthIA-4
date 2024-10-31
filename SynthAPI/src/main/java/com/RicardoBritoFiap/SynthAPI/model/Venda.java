package com.RicardoBritoFiap.SynthAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venda_seq_gen")
    @SequenceGenerator(name = "venda_seq_gen", sequenceName = "venda_seq", allocationSize = 1)
    private Long id;

    @NotBlank
    private String valor;

    @NotBlank
    private String descvenda;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}