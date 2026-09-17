package com.ferreira_gn.dsc.repository;

import com.ferreira_gn.dsc.entity.LoanEntity;
import com.ferreira_gn.dsc.enums.LoanState;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<LoanEntity, Long> {
  public List<LoanEntity> findByUsuarioIdAndStatus(Long usuarioId, LoanState status);

  public List<LoanEntity> findByDataDevolucaoPrevistaBeforeAndStatus(
      LocalDate data,
      LoanState status
  );
}
