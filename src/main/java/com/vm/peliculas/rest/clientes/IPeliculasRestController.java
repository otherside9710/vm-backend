package com.vm.peliculas.rest.clientes;

import com.vm.peliculas.model.dto.PeliculaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface IPeliculasRestController {
    @RequestMapping(value = "/findAll", produces = { "application/json" }, method = RequestMethod.GET)
    ResponseEntity<?> findAll();

    @RequestMapping(value = "/findByNombre", produces = { "application/json" }, method = RequestMethod.GET)
    ResponseEntity<?> findByNombre(@RequestParam String search);

    @RequestMapping(value = "/findById", produces = { "application/json" }, method = RequestMethod.GET)
    ResponseEntity<?> findById(@RequestParam String id);

    @RequestMapping(value = "/add", produces = { "application/json" }, method = RequestMethod.POST)
    ResponseEntity<?> save(PeliculaDTO peliculaDTO);
}
