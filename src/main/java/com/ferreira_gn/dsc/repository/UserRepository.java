package com.ferreira_gn.dsc.repository;

import com.ferreira_gn.dsc.entity.UserEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
  public List<UserEntity> findByNomeContaining(String nome);
}
