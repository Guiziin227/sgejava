package com.github.guiziin227.sgejava.service;

import com.github.guiziin227.sgejava.exceptions.DbIntegrityVioletionException;
import com.github.guiziin227.sgejava.model.Evento;
import com.github.guiziin227.sgejava.repository.EventoRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventoService {

    private final Logger logger = LoggerFactory.getLogger(EventoService.class);

    private final EventoRepository eventoRepository;

    @Transactional
    public Evento createEvento(Evento evento) {
        logger.info("Creating event: {}", evento.getNome());
        try {
            return eventoRepository.save(evento);
        } catch (Exception e) {
            logger.error("Error creating event: {}", e.getMessage());
            throw new DbIntegrityVioletionException(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    public List<Evento> getAllEventos() {
        logger.info("Retrieving all events");
        return eventoRepository.findAll();
    }
}
