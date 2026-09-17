package com.ferreira_gn.dsc.entity;

import com.ferreira_gn.dsc.enums.LoanState;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "loans")
public class LoanEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "usuarior_id")
  private UserEntity user;

  private Date dataEmprestimo;

  private Date dataDevolucaoPrevista;

  private Date dataDevolucaoEfetiva;

  @Enumerated(EnumType.STRING)
  private LoanState status;

  private float valorMulta;

  @ManyToMany
  @JoinTable(
    name = "item_emprestimo",
    joinColumns = @JoinColumn(name = "livro_id"),
    inverseJoinColumns = @JoinColumn(name = "emprestimo_id")
  )
  private List<BookEntity> livros;
}
