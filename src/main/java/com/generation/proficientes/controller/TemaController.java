package com.generation.proficientes.controller;
import com.generation.proficientes.repository.TemaRepository;
import com.generation.proficientes.model.Tema;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/temas")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class TemaController {
    @Autowired
    private TemaRepository temaRepository;

    @GetMapping
    public ResponseEntity<List<Tema>> getAll(){

        return ResponseEntity.ok(temaRepository.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Tema> getById(@PathVariable Long id) {
        return temaRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }
    @PostMapping
    public ResponseEntity<Tema> post(@Valid @RequestBody Tema tema){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(temaRepository.save(tema));

    }

    @PutMapping
    public ResponseEntity<Tema> put(@Valid @RequestBody Tema tema){

        return temaRepository.findById(tema.getId())
                .map(resposta -> ResponseEntity.status(HttpStatus.CREATED)
                        .body(temaRepository.save(tema)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        Optional<Tema> tema = temaRepository.findById(id);

        if (tema.isEmpty())
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        temaRepository.deleteById(id);
    }
}
