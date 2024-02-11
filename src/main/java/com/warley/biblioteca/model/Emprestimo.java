package com.warley.biblioteca.model;

import com.warley.biblioteca.util.enums.StatusEmprestimo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "emprestimo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emprestimo_id")
    private Long id;

    @ManyToOne(targetEntity = Livro.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "livro_id")
    private Livro livro;

    @ManyToOne(targetEntity = Usuario.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(name = "data_emprestimo", nullable = false)
    private Date dataEmprestimo;

    @Column(name = "data_devolucao")
    private Date dataDevolucao;

    @Column(name = "status_emprestimo", nullable = false, columnDefinition = "ENUM('ABERTO', 'DEVOLVIDO', 'ATRASADO')")
    private StatusEmprestimo statusEmprestimo;

}
