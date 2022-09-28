package com.example.operador.transformacion;

import java.util.List;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.model.Persona;

import reactor.core.publisher.Flux;

public class Transformacion {

	private static final Logger log = LoggerFactory.getLogger(Transformacion.class);

    public void map(){

        List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Juan", 27));
		personas.add(new Persona(2, "pedro", 28));
		personas.add(new Persona(3, "pablo", 29));

        Flux.fromIterable(personas)
        .map(p->{
            p.setEdad(p.getEdad() + 10);
            return p;
        })
        .subscribe(i-> log.info("i + " + i));
    }

    public void flatMap(){

        List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Juan", 27));
		personas.add(new Persona(2, "pedro", 28));
		personas.add(new Persona(3, "pablo", 29));

        Flux.fromIterable(personas)
        .flatMap(p->{
            p.setEdad(p.getEdad() + 10);
            return Flux.just(p);
        })
        .subscribe(i-> log.info("i + " + i));
    }

    public void groupBy(){

        List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(3, "Juan", 27));
		personas.add(new Persona(2, "pedro", 28));
		personas.add(new Persona(3, "pablo", 29));

        Flux.fromIterable(personas)
.        groupBy(Persona::getIdPersona)
        .flatMap(idFlux->idFlux.collectList())
        .subscribe(i-> log.info("i + " + i));
    }    
}
