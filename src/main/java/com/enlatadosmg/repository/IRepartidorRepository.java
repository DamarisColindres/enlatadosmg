package com.enlatadosmg.repository;

import com.enlatadosmg.entity.Repartidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepartidorRepository extends JpaRepository<Repartidor, String> {
}
