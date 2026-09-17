package com.ferreira_gn.dsc.repository;

import com.ferreira_gn.dsc.dto.QuantidadeCategoriaDTO;
import com.ferreira_gn.dsc.entity.BookEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
  public List<BookEntity> findByQuantidadeDisponivelGreaterThanOrderByTituloAsc(
    int quantidade
  );

  public List<BookEntity> findByCategoriaNome(String nome);

  public List<BookEntity> findByAutorNomeOrderByAnoPublicacaoAsc(String nome);

  @Query(
    """
        SELECT new com.ferreira_gn.dsc.dto.QuantidadeCategoriaDTO(
            l.categoria.nome,
            COUNT(l)
        )
        FROM Livro l
        GROUP BY l.categoria.nome
        ORDER BY COUNT(l) DESC
    """
  )
  List<QuantidadeCategoriaDTO> contarLivrosPorCategoria();
}
