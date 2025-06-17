package com.github.guiziin227.sgejava.controller;

import com.github.guiziin227.sgejava.model.Evento;
import com.github.guiziin227.sgejava.service.EventoService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/eventos")
@RequiredArgsConstructor
public class EventoController {

    private final Logger logger = LoggerFactory.getLogger(EventoController.class);

    private final EventoService eventoService;

    @PostMapping
    public ResponseEntity<Evento> createEvento(@RequestBody Evento evento) {
        logger.info("Criando novo evento: {}", evento.getNome());
        Evento createdEvento = eventoService.createEvento(evento);
        return ResponseEntity.ok(createdEvento);
    }

    @GetMapping
    public List<Evento> getAllEventos() {
        return eventoService.getAllEventos();
    }
}
