package com.vm.peliculas.rest.clientes;

import com.vm.peliculas.model.dto.PeliculaDTO;
import com.vm.peliculas.model.entity.Peliculas;
import com.vm.peliculas.model.repository.PeliculasRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/peliculas")
public class PeliculasRestController implements IPeliculasRestController {

    @Autowired
    PeliculasRepository peliculasRepository;

    //Metodo para buscar todos los registros de la tabla peliculas
    public ResponseEntity<?> findAll() {
        List<PeliculaDTO> result = new ArrayList<>();
        try {
            List<Peliculas> lista = peliculasRepository.findAll();
            for (Peliculas peliculas : lista) {
                result.add(PeliculaDTO.createFromEntity(peliculas));
            }
        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    //Metodo para la busqueda por nombre de la pelicula, recibe un parametro por el cual haremos la busqueda
    public ResponseEntity<?> findByNombre(@RequestParam String search){
        List<Peliculas> result;
        List<PeliculaDTO> result2 = new ArrayList<>();
        try {
            result = peliculasRepository.findByNombreLike(search);
            result2 = new ModelMapper().map(result,result2.getClass());
            return new ResponseEntity<>(result2, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    //Metodo para la busqueda por nombre de la pelicula, recibe un parametro por el cual haremos la busqueda
    public ResponseEntity<?> findById(@RequestParam String id){
        Peliculas result;
        PeliculaDTO result2 = new PeliculaDTO();
        try {
            result = peliculasRepository.findById(id);
            result2 = new ModelMapper().map(result,result2.getClass());
            return new ResponseEntity<>(result2, HttpStatus.OK);
        } catch (Exception e){
            System.out.println(e.toString());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    //Metodo para guardar registros en la tabla peliculas
    //ediqueta para que solo haga rollback si todo sale bien.
    @Transactional
    public ResponseEntity<?> save(@RequestBody PeliculaDTO peliculaDTO) {
        try {
            //se guardan los registros que llegaron en el objeto peliculaDTO
            //con el metodo que tenemos en el dto seteamos los datos a la entidad para guardar
            peliculasRepository.save(peliculaDTO.toEntity());
            //retornamos el objeto que guardamos
            return new ResponseEntity<>(peliculaDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            //si hay un error entrara aqui y mandara un error 500 INTERNAL SERVER ERROR
            System.out.println(e.toString());
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
