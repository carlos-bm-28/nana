package com.Nanas.demo.infraestructura.adaptadores.persistencia.entidades;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.PrePersist;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "nanas")
public class NanaEntity {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id_nana")
    private Integer idNana;

    //id_usuario es la clave foranea
    //cualquier cambio en la tabla usuarios se reflejara en la tabla clientes
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private UsuarioEntity usuario;

    @Column(name = "id_universidad", nullable = false)
    private Integer idUniversidad;

    @Column(name = "codigo_universitario", nullable = false)
    private String codigoUniversitario;

    @Column(name = "carrera", nullable = false)   
    private String carrera;

    @Column(name = "ciclo", nullable = false)
    private Integer ciclo;

    //sin limite de caracteres
    @Lob
    @Column(name = "descripcion")
    private String descripcion;

    @Lob
    @Column(name = "experiencia")
    private String experiencia;

    @Column(name = "tarifa_hora", nullable = false)   
    private BigDecimal tarifaHora;

    @Column(name = "disponibilidad")
    private String disponibilidad;

    @Column(name = "verificado")
    private Boolean verificado;

    @Column(name = "rating_promedio")
    private BigDecimal ratingPromedio;

    @Column(name = "cantidad_reviews")
    private Integer cantidadReviews;

    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;


 
@PrePersist
protected void onCreate() {

    this.fechaCreacion = LocalDateTime.now();

    if (this.disponibilidad == null) {
        this.disponibilidad = "DISPONIBLE";
    }

    if (this.verificado == null) {
        this.verificado = false;
    }

    if (this.ratingPromedio == null) {
        this.ratingPromedio = BigDecimal.ZERO;
    }

    if (this.cantidadReviews == null) {
        this.cantidadReviews = 0;
    }
}


    public Integer getIdNana() {
        return idNana;
    }


    public void setIdNana(Integer idNana) {
        this.idNana = idNana;
    }


    public UsuarioEntity getUsuario() {
        return usuario;
    }


    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }


    public Integer getIdUniversidad() {
        return idUniversidad;
    }


    public void setIdUniversidad(Integer idUniversidad) {
        this.idUniversidad = idUniversidad;
    }


    public String getCodigoUniversitario() {
        return codigoUniversitario;
    }


    public void setCodigoUniversitario(String codigoUniversitario) {
        this.codigoUniversitario = codigoUniversitario;
    }


    public String getCarrera() {
        return carrera;
    }


    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }


    public Integer getCiclo() {
        return ciclo;
    }


    public void setCiclo(Integer ciclo) {
        this.ciclo = ciclo;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getExperiencia() {
        return experiencia;
    }


    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }


    public BigDecimal getTarifaHora() {
        return tarifaHora;
    }


    public void setTarifaHora(BigDecimal tarifaHora) {
        this.tarifaHora = tarifaHora;
    }


    public String getDisponibilidad() {
        return disponibilidad;
    }


    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }


    public Boolean getVerificado() {
        return verificado;
    }


    public void setVerificado(Boolean verificado) {
        this.verificado = verificado;
    }


    public BigDecimal getRatingPromedio() {
        return ratingPromedio;
    }


    public void setRatingPromedio(BigDecimal ratingPromedio) {
        this.ratingPromedio = ratingPromedio;
    }


    public Integer getCantidadReviews() {
        return cantidadReviews;
    }


    public void setCantidadReviews(Integer cantidadReviews) {
        this.cantidadReviews = cantidadReviews;
    }


    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }


    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    


}
