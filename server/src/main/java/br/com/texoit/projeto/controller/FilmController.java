package br.com.texoit.projeto.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.texoit.projeto.model.Film;
import br.com.texoit.projeto.service.FilmService;

/**
 * Classe responsável para chamada dos serviços.

 * @author Bernardo Xavier
 * 

*/
@Controller
@RequestMapping(path = "/rest/films")
public class FilmController {
	
	@Autowired
    private FilmService filmService;

    @GetMapping()
    public ResponseEntity<?> list() {
        return new ResponseEntity<>(filmService.listAll(), HttpStatus.OK);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findByTitle(@PathVariable(value = "id", required = true) Integer id) {
        return new ResponseEntity<>(filmService.findById(id), HttpStatus.OK);
    }
    
    @PostMapping(path = "create")
    public ResponseEntity<?> create(@Valid @RequestBody Film film) {
        return new ResponseEntity<>(this.filmService.create(film), HttpStatus.OK);
    }

    @PutMapping(path = "update")
    public ResponseEntity<?> update(@Valid @RequestBody Film film) {
        Film update = this.filmService.update(film);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id", required = true) Integer id) {
        this.filmService.delete(id);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

    @GetMapping(path = "listOfNominees")
    public ResponseEntity<?> findlistOfNominees() {
        return new ResponseEntity<>(filmService.findlistOfNominees(), HttpStatus.OK);
    }
}
