package com.github.guiziin227.sgejava.model;

import com.github.guiziin227.sgejava.model.Curso;
import com.github.guiziin227.sgejava.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name= "tb_evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false, length = 100)
    private String site;

    @ManyToOne(optional = false)
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    @ManyToOne(optional = false)
    @JoinColumn(name = "coordenador_id", nullable = false)
    private User coordenador;

    @Column(nullable = false)
    private Date dataLimiteInscricao;

    @Column(nullable = false)
    private Date dataEvento;

    @Column(nullable = false)
    private int cargaHoraria;

    @Column(nullable = false, length = 120)
    private String local;
}
