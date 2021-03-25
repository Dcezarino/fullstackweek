package br.com.fullstackweek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fullstackweek.entity.GruposPrioridades;

@Repository
public interface GruposPrioridadesRepository extends JpaRepository<GruposPrioridades, Long>{

}
