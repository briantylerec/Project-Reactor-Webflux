package com.example.operador.condicional;

import java.util.List;
import java.time.Duration;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.model.Persona;

import reactor.core.publisher.Flux;

public class Condicional {

	private static final Logger log = LoggerFactory.getLogger(Condicional.class);

    public void defaultIfEmpty(){
        
        //si tiene data ya no ejecuta
        Flux.just(new Persona(1, "pablo", 15))
            .defaultIfEmpty(new Persona(90,"DEFAULT",99))
            .subscribe(x->log.info(x.toString()));

            //los dos controlan los errores con un valor default
        // Mono.empty()
        //     .defaultIfEmpty(new Persona(90,"DEFAULT",99))
        //     .subscribe(x->log.info(x.toString()));
        
        // Flux.empty()
        //     .defaultIfEmpty(new Persona(90,"DEFAULT",99))
        //     .subscribe(x->log.info(x.toString()));

    }

    public void takeUntil(){
        
        List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Juan", 5));
		personas.add(new Persona(2, "pedro", 21));
		personas.add(new Persona(3, "pablo", 29));

        Flux.fromIterable(personas)
        .takeUntil(p-> p.getEdad()<21)//se ejecuta hasta que encuentra que cumple la condicion y termina como un break
        .subscribe(x->log.info(x.toString()));
    }

    public void timeOut() throws InterruptedException{
        
        List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Juan", 5));
		personas.add(new Persona(2, "pedro", 21));
		personas.add(new Persona(3, "pablo", 29));

        Flux.fromIterable(personas)
        .delayElements(Duration.ofSeconds(3))
        .timeout(Duration.ofSeconds(2)) //  si el tiempo de espera es mayor al establecido se lanza una TimeoutException
        .subscribe(x->log.info(x.toString()));

        Thread.sleep(10000);
    }    
}