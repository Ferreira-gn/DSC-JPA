package com.ferreira_gn.dsc.entity;

import jakarta.persistence.Entity;
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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "books")
public class BookEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private String isbn;

  private String titulo;

  private String editora;

  private Date anoPublicacao;

  private Integer numeroPaginas;

  private Integer quantidadeTotal;

  private Integer quantidadeDisponivel;

  @ManyToMany
  @JoinTable(
    name = "livro_autor",
    joinColumns = @JoinColumn(name = "livro_id"),
    inverseJoinColumns = @JoinColumn(name = "autor_id")
  )
  private List<AuthorEntity> autores;

  @ManyToMany
  private List<LoanEntity> emprestimos;

  @ManyToOne
  @JoinColumn(name = "categoria_id")
  private CategoryEntity categoria;
}
