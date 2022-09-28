package com.example.operador.matematico;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Comparator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.model.Persona;

import reactor.core.publisher.Flux;

public class Matematico {

	private static final Logger log = LoggerFactory.getLogger(Matematico.class);

    public void average(){
        List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Juan", 5));
		personas.add(new Persona(2, "pedro", 21));
		personas.add(new Persona(3, "pablo", 21));

        Flux.fromIterable(personas)
        .filter(p -> p.getEdad()>20)
        .collect(Collectors.averagingInt(Persona::getEdad))//promeduo de todos los collectores
        .subscribe(x->log.info(x.toString()));
    }

    public void count(){
        List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Juan", 5));
		personas.add(new Persona(2, "pedro", 21));
		personas.add(new Persona(3, "pablo", 21));

        Flux.fromIterable(personas)
        .filter(p -> p.getEdad()>20)
        .count()
        .subscribe(x->log.info(x.toString()));
    }

    public void min(){
        List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Juan", 5));
		personas.add(new Persona(2, "pedro", 21));
		personas.add(new Persona(3, "pablo", 22));

        Flux.fromIterable(personas)
        //.filter(p -> p.getEdad()>20)
        .collect(Collectors.minBy(Comparator.comparing(Persona::getEdad)))
        .subscribe(x->log.info(x.get().toString()));
    }

    public void suma(){
        List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Juan", 5));
		personas.add(new Persona(2, "pedro", 21));
		personas.add(new Persona(3, "pablo", 22));

        Flux.fromIterable(personas)
        //.filter(p -> p.getEdad()>20)
        .collect(Collectors.summingInt(Persona::getEdad))
        .subscribe(x->log.info(x.toString()));
    }

    public void summarizing(){
        List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Juan", 5));
		personas.add(new Persona(2, "pedro", 21));
		personas.add(new Persona(3, "pablo", 22));

        Flux.fromIterable(personas)
        //.filter(p -> p.getEdad()>20)
        .collect(Collectors.summarizingInt(Persona::getEdad))
        .subscribe(x->log.info(x.toString()));

        // da un resultado de las opraciones basicas
        // IntSummaryStatistics{count=3, sum=48, min=5, average=16.000000, max=22}
    }
}