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
public class Oferta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oferta_seq_gen")
    @SequenceGenerator(name = "oferta_seq_gen", sequenceName = "oferta_seq", allocationSize = 1)
    private Long id;

    @NotBlank
    private String desconto;

    @NotBlank
    private String porcetagem;

    @OneToOne
    @JoinColumn(name = "venda_id")
    private Venda venda;
}