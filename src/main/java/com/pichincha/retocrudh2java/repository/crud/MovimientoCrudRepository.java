package com.pichincha.retocrudh2java.repository.crud;

import com.pichincha.retocrudh2java.entity.Movimiento;
import com.pichincha.retocrudh2java.entity.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovimientoCrudRepository extends JpaRepository<Movimiento, Integer> {

//    @Query(value = "select * from transactions where wallet_id = :fechaInicial and description like %:fechaFinal%", nativeQuery = true)
//    Optional<List<Reporte>> reportePorIdCliente(@Param("fechaInicial") String fechaInicial, @Param("fechaFinal") String fechaFinal);
}
