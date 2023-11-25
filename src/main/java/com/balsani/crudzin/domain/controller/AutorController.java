package com.balsani.crudzin.domain.controller;

import com.balsani.crudzin.domain.BusinessException;
import com.balsani.crudzin.domain.model.Autor;
import com.balsani.crudzin.domain.model.dto.AutorRequest;

import com.balsani.crudzin.domain.model.dto.AutorRequestLivro;
import com.balsani.crudzin.domain.model.dto.AutorResponse;
import com.balsani.crudzin.domain.repository.AutorRepository;
import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autor")
public class AutorController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AutorController.class);
    private final AutorRepository repository;

    public AutorController(AutorRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody AutorRequest request) {
        Autor autor = request.toModel();
        LOGGER.info("Um novo autor foi criado = {}", autor);
        Autor bodyResponse = repository.save(autor);

        return ResponseEntity.status(HttpStatus.CREATED).body(bodyResponse);
    }

    @PostMapping("/livroAutor")
    public ResponseEntity<?> create(@Valid @RequestBody AutorRequestLivro request) {
        Autor autor = request.toModel();
        LOGGER.info("Um novo autor foi criado = {}", autor);
        Autor bodyResponse = repository.save(autor);

        return ResponseEntity.status(HttpStatus.CREATED).body(bodyResponse);
    }

    @GetMapping
    public ResponseEntity<List<?>> getAll() {
        List<Autor> autores = repository.findAll();
        LOGGER.info("Autores = {} ", autores);
        return ResponseEntity.ok(
                autores.stream()
                        .map(AutorResponse::new)
                        .toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@RequestBody @PathVariable Long id) {
        Optional<Autor> autor = repository.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(autor);

    }

    @PutMapping("/byId/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid AutorRequest request) {
        Autor autor = repository.findById(id).orElseThrow(()
                -> new BusinessException("Autor nãão encontrado"));
        autor.setNome(request.getNome());
        autor.setEmail(request.getEmail());


        Autor save = repository.save(autor);

        AutorResponse response = new AutorResponse(save);


        return  ResponseEntity.status(HttpStatus.OK).body(response);


    }
}
