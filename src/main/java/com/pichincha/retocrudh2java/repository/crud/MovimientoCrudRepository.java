package com.pichincha.retocrudh2java.repository.crud;

import com.pichincha.retocrudh2java.entity.MovimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoCrudRepository extends JpaRepository<MovimientoEntity, Integer> {
}
