package com.vm.peliculas.model.dto;

import com.vm.peliculas.model.entity.Peliculas;

public class PeliculaDTO {
    private Integer id;
    private String nombre;
    private String descripcion;
    private String director;
    private String genero;
    private Double precio;
    private Integer cantidad;
    private String urlCaratula;

    public PeliculaDTO() {
    }

    public PeliculaDTO(Integer id, String nombre, String descripcion,
                       String director, String genero, Double precio,
                       Integer cantidad, String urlCaratula) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.director = director;
        this.genero = genero;
        this.precio = precio;
        this.cantidad = cantidad;
        this.urlCaratula = urlCaratula;
    }

    //metodo para obtener los parametros de la entidad
    public static PeliculaDTO createFromEntity(Peliculas peliculas){
        return new PeliculaDTO(
                peliculas.getId(),
                peliculas.getNombre(),
                peliculas.getDescripcion(),
                peliculas.getDirector(),
                peliculas.getGenero(),
                peliculas.getPrecio(),
                peliculas.getCantidad(),
                peliculas.getUrlCaratula()
        );
    }

    //meotodo para enviar los parametros a la entidad
    public Peliculas toEntity(){
        Peliculas peliculas = new Peliculas();
        peliculas.setId(this.id);
        peliculas.setNombre(this.nombre);
        peliculas.setDescripcion(this.descripcion);
        peliculas.setDirector(this.director);
        peliculas.setGenero(this.genero);
        peliculas.setPrecio(this.precio);
        peliculas.setCantidad(this.cantidad);
        peliculas.setUrlCaratula(this.urlCaratula);
        return peliculas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getUrlCaratula() {
        return urlCaratula;
    }

    public void setUrlCaratula(String urlCaratula) {
        this.urlCaratula = urlCaratula;
    }
}
