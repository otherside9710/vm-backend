package com.vm.peliculas.model.repository;

import com.vm.peliculas.model.entity.Peliculas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PeliculasRepository extends PagingAndSortingRepository<Peliculas, String> {
    List<Peliculas> findAll();

    Peliculas save(Peliculas peliculas);

    @Query(value = "SELECT p from Peliculas p where p.nombre LIKE %?1%")
    List<Peliculas> findByNombreLike(String search);

    @Query(value = "SELECT * from peliculas p where p.id = ?1", nativeQuery = true)
    Peliculas findById(String id);
}
