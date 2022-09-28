package com.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Persona {

    private Integer idPersona;
    private String nombres;
    private Integer edad;
    
    public Persona() {
    }

    public Persona(Integer idPersona, String nombres, Integer edad) {
        this.idPersona = idPersona;
        this.nombres = nombres;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona [edad=" + edad + ", idPersona=" + idPersona + ", nombres=" + nombres + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idPersona == null) ? 0 : idPersona.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Persona other = (Persona) obj;
        if (idPersona == null) {
            if (other.idPersona != null)
                return false;
        } else if (!idPersona.equals(other.idPersona))
            return false;
        return true;
    }
}