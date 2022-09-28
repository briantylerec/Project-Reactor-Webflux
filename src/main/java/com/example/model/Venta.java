package com.example.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Venta {

    private Integer idVenta;
    private LocalDateTime fecha;

    public Venta(Integer idVenta, LocalDateTime fecha) {
        this.idVenta = idVenta;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Venta [fecha=" + fecha + ", idVenta=" + idVenta + "]";
    }
}