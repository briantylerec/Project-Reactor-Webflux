package com.example.operador.filtrado;

import java.util.List;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.model.Persona;

import reactor.core.publisher.Flux;

public class Filtrado {

	private static final Logger log = LoggerFactory.getLogger(Filtrado.class);

    public void filter(){
        List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Juan", 5));
		personas.add(new Persona(2, "pedro", 21));
		personas.add(new Persona(3, "pablo", 29));

        Flux.fromIterable(personas)
        .filter(p->p.getEdad()>20)
        .subscribe(i-> log.info("i + " + i));
    }


    public void distinct(){
        List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Juan", 5));
		personas.add(new Persona(1, "pedro", 21));
		personas.add(new Persona(3, "pablo", 29));

        Flux.fromIterable(personas)
        .distinct(Persona::getIdPersona)
        .subscribe(i-> log.info("i + " + i));
    }

    public void take(){
        List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Juan", 5));
		personas.add(new Persona(1, "pedro", 21));
		personas.add(new Persona(3, "pablo", 29));

        Flux.fromIterable(personas)
        .take(2)//2 primeros elementos
        .subscribe(i-> log.info("i + " + i));
    }
    
    public void takeLast(){
        List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Juan", 5));
		personas.add(new Persona(1, "pedro", 21));
		personas.add(new Persona(3, "pablo", 29));

        Flux.fromIterable(personas)
        .takeLast(2)//2 ultimos elementos
        .subscribe(i-> log.info("i + " + i));
    }

    public void skip(){
        List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Juan", 5));
		personas.add(new Persona(1, "pedro", 21));
		personas.add(new Persona(3, "pablo", 29));

        Flux.fromIterable(personas)
        .skip(1)//se salta el un elemento del inicio
        .subscribe(i-> log.info("i + " + i));
    }

    public void skipLast(){
        List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Juan", 5));
		personas.add(new Persona(1, "pedro", 21));
		personas.add(new Persona(3, "pablo", 29));

        Flux.fromIterable(personas)
        .skipLast(1)//se salta 1 elemento del ultimo
        .subscribe(i-> log.info("i + " + i));
    }  
}
