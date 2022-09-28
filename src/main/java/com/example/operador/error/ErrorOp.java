package com.example.operador.error;

import java.util.List;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.model.Persona;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ErrorOp {

	private static final Logger log = LoggerFactory.getLogger(ErrorOp.class);

    public void retry(){
        List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Juan", 5));
		personas.add(new Persona(2, "pedro", 21));
		personas.add(new Persona(3, "pablo", 29));

        Flux.fromIterable(personas)
        .concatWith(Flux.error(new RuntimeException("Un error")))
        .retry(1)
        .doOnNext(i-> log.info(i.toString()))
        .subscribe();
    }

    public void errorReturn(){
        List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Juan", 5));
		personas.add(new Persona(2, "pedro", 21));
		personas.add(new Persona(3, "pablo", 29));

        Flux.fromIterable(personas)
        .concatWith(Flux.error(new RuntimeException("Un error")))
        .onErrorReturn(new Persona(0, "ABC", 29))
        .subscribe(i-> log.info(i.toString()));
    }

    public void errorResume(){
        List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Juan", 5));
		personas.add(new Persona(2, "pedro", 21));
		personas.add(new Persona(3, "pablo", 29));

        Flux.fromIterable(personas)
        .concatWith(Flux.error(new RuntimeException("Un error")))
        .onErrorResume(e -> Mono.just(new Persona(0, "ABC", 29)))
        .subscribe(i-> log.info(i.toString()));
    }

    public void errorMap(){
        List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Juan", 5));
		personas.add(new Persona(2, "pedro", 21));
		personas.add(new Persona(3, "pablo", 29));

        Flux.fromIterable(personas)
        .concatWith(Flux.error(new RuntimeException("Un error")))
        .onErrorMap(e -> new InterruptedException(e.getMessage()))
        .subscribe(i-> log.info(i.toString()));
    }    
}