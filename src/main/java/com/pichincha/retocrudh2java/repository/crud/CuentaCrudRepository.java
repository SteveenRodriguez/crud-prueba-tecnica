package com.pichincha.retocrudh2java.repository.crud;

import com.pichincha.retocrudh2java.entity.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaCrudRepository extends JpaRepository<CuentaEntity, Integer> {
}
