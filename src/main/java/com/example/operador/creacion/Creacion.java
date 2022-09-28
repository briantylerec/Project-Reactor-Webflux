package com.example.operador.creacion;

import java.util.List;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.model.Persona;

import io.reactivex.rxjava3.core.Observable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Creacion {
    
	private static final Logger log = LoggerFactory.getLogger(Creacion.class);
    
    public void justFrom(){
        Mono.just(new Persona(1,"",29));
        //Flux.fromIterable(coleccion);
        //Observable.just(item);
    }

    public void empty(){
        Mono.empty();
        Flux.empty();
        Observable.empty();
    }


    public void range(){
        Flux.range(0,3)
        .doOnNext(i->log.info("i : " + i))
        .subscribe();
    }

    public void repeat(){
        List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Juan", 27));
		personas.add(new Persona(2, "pedro", 28));
		personas.add(new Persona(3, "pablo", 29));

        Flux.fromIterable(personas)
            .repeat(3)
            .subscribe(i-> log.info("i + " + i));

        // Mono.just(personas)
        //     .repeat(3)
        //     .subscribe(i-> log.info("i + " + i));
    }
}
