package com.example.demoreactor;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.model.Persona;
import com.example.operador.combinacion.Combinacion;
import com.example.operador.condicional.Condicional;
import com.example.operador.creacion.Creacion;
import com.example.operador.error.ErrorOp;
import com.example.operador.filtrado.Filtrado;
import com.example.operador.matematico.Matematico;
import com.example.operador.transformacion.Transformacion;

import io.reactivex.rxjava3.core.Observable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class DemoReactorApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

	public void reactor(){
		Mono.just(new Persona(1, "Mito", 29))
			.doOnNext(p->log.info("reactor " + p.getNombres()))
			.subscribe(p->log.info("reactor " + p.getNombres()));
	}

	public void rxjava3(){
		Observable.just(new Persona(1, "Mito", 29))
			.doOnNext(p->log.info("rxjava " + p.getNombres()))
			.subscribe(p->log.info("rxjava " + p.getNombres()));
	}

	public void mono(){
		Mono.just(new Persona(1, "Mono", 29)).subscribe(p->log.info(p.getNombres()));
	}

	public void flux(){
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Juan", 27));
		personas.add(new Persona(2, "pedro", 28));
		personas.add(new Persona(3, "pablo", 29));

		Flux.fromIterable(personas).subscribe(p->log.info(p.getNombres()));
	}

	public void fluxMono(){
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Juan", 27));
		personas.add(new Persona(2, "pedro", 28));
		personas.add(new Persona(3, "pablo", 29));

		Flux<Persona> flux = Flux.fromIterable(personas);
		flux.collectList().subscribe(lista -> log.info(lista.toString()));
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoReactorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Matematico m = new Matematico();
		m.summarizing();

		// Condicional c = new Condicional();
		// c.timeOut();

		// Creacion app = new Creacion();
		// app.repeat();

		// Transformacion tr = new Transformacion();
		// tr.groupBy();

		// Filtrado f = new Filtrado();
		// f.take();

		// Combinacion c = new Combinacion();
		// c.zip();

		// ErrorOp e = new ErrorOp();
		// e.errorMap();
	}
}