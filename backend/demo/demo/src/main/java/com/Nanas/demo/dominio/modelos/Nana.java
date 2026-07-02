package com.Nanas.demo.dominio.modelos;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class Nana extends Usuario {

    private Integer idNana;
    private Integer idUniversidad;
    private String codigoUniversitario;
    private String carrera;
    private Integer ciclo;
    private String descripcion;
    private String experiencia;
    private BigDecimal tarifaHora;
    private String disponibilidad; 
    private Boolean verificado;
    private BigDecimal ratingPromedio;
    private Integer cantidadReviews;
    private LocalDateTime fechaCreacion;

    

    //datos de direccion
    private double latitud;
    private double longitud;
private String departamento;
private String provincia;
private String distrito;
private String direccion;
private String referencia;

    public Nana() {
    }

    public Integer getIdNana() {
        return idNana;
    }

    public void setIdNana(Integer idNana) {
        this.idNana = idNana;
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

    public Boolean isVerificado() {
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

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getDepartamento() {
    return departamento;
}

public void setDepartamento(String departamento) {
    this.departamento = departamento;
}

public String getProvincia() {
    return provincia;
}

public void setProvincia(String provincia) {
    this.provincia = provincia;
}

public String getDistrito() {
    return distrito;
}

public void setDistrito(String distrito) {
    this.distrito = distrito;
}

public String getDireccion() {
    return direccion;
}

public void setDireccion(String direccion) {
    this.direccion = direccion;
}

public String getReferencia() {
    return referencia;
}

public void setReferencia(String referencia) {
    this.referencia = referencia;
}
    


}
