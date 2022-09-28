package com.example.operador.combinacion;

import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.model.Persona;
import com.example.model.Venta;

import reactor.core.publisher.Flux;

public class Combinacion {

	private static final Logger log = LoggerFactory.getLogger(Combinacion.class);

    public void merge(){
        List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Juan", 5));
		personas.add(new Persona(2, "pedro", 21));
		personas.add(new Persona(3, "pablo", 29));

        List<Persona> personas2 = new ArrayList<>();
		personas2.add(new Persona(4, "Juan", 5));
		personas2.add(new Persona(5, "pedro", 21));
		personas2.add(new Persona(6, "pablo", 29));

        List<Venta> ventas = new ArrayList<>();
        ventas.add(new Venta(1, LocalDateTime.now()));

        Flux<Persona> f1 = Flux.fromIterable(personas);
        Flux<Persona> f2 = Flux.fromIterable(personas2);
        Flux<Venta> f3 = Flux.fromIterable(ventas);

        Flux.merge(f1, f2, f3)
        .subscribe(i-> log.info(i.toString()));
    }

    public void zip(){
        List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Juan", 5));
		personas.add(new Persona(2, "pedro", 21));
		personas.add(new Persona(3, "pablo", 29));

        List<Persona> personas2 = new ArrayList<>();
		personas2.add(new Persona(4, "andres", 5));
		personas2.add(new Persona(5, "fernando", 21));
		personas2.add(new Persona(6, "esteban", 29));

        List<Venta> ventas = new ArrayList<>();
        ventas.add(new Venta(1, LocalDateTime.now()));

        Flux<Persona> f1 = Flux.fromIterable(personas);
        Flux<Persona> f2 = Flux.fromIterable(personas2);
        Flux<Venta> f3 = Flux.fromIterable(ventas);

        // Flux.zip(f1, f2, (p1, p2) -> String.format("Flux1: %s, Flux2: %s", p1, p2))
        // .subscribe(i -> log.info("i : " + i));

        Flux.zip(f1, f2, f3)
        .subscribe(i -> log.info("o : " + i));
    }

    public void zipWith(){
        List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Juan", 5));
		personas.add(new Persona(2, "pedro", 21));
		personas.add(new Persona(3, "pablo", 29));

        List<Persona> personas2 = new ArrayList<>();
		personas2.add(new Persona(4, "andres", 5));
		personas2.add(new Persona(5, "fernando", 21));
		personas2.add(new Persona(6, "esteban", 29));

        List<Venta> ventas = new ArrayList<>();
        ventas.add(new Venta(1, LocalDateTime.now()));

        Flux<Persona> f1 = Flux.fromIterable(personas);
        Flux<Persona> f2 = Flux.fromIterable(personas2);
        Flux<Venta> f3 = Flux.fromIterable(ventas);

        f1.zipWith(f2, (p1, p2) -> String.format("Flux1: %s, Flux2: %s", p1, p2))
        .subscribe(i -> log.info("i : " + i));
    }    
}
