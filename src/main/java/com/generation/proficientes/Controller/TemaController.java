package com.generation.proficientes.Controller;
import com.generation.proficientes.Repository.TemaRepository;
import com.generation.proficientes.model.Tema;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("titulo/{titulo}")
    public ResponseEntity<List<Tema>> getByTitulo(@PathVariable String titulo) {
        return ResponseEntity.ok(temaRepository
                .findAllByDescricaoContainingIgnoreCase(titulo));
    }

    @GetMapping("/descricao/{descricao}")
    public ResponseEntity<List<Tema>> getByTitlle(@PathVariable String descricao){
       return ResponseEntity.ok(temaRepository
       .findAllByDescricaoContainingIgnoreCase(descricao));
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
}




