package br.com.texoit.projeto.service;


import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import br.com.texoit.projeto.model.Film;

/**
 * Classe responsável por executar testes unitários.

 * @author Bernardo Xavier
 * 

*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class FilmServiceTest {

    @Autowired
    private FilmService filmService;


    @Test
    public void createFilm() {
        Date date = new Date(0);
        ZoneId timeZone = ZoneId.systemDefault();
        LocalDate getLocalDate = date.toInstant().atZone(timeZone).toLocalDate();
        Film t1 = new Film(null, null, null, null, null);
        t1.setYear(getLocalDate.getYear());
        t1.setTitle("Teste 1");
        t1.setStudios("Teste 1");
        t1.setProducers("Teste 1");
        t1.setWinner("Teste 1");


        Film r1 = this.filmService.create(t1);
        Assert.notNull(r1.getTitle(), "erro ao criar filme t1");

        Film t2 = new Film(null, null, null, null, null);
        t1.setYear(getLocalDate.getYear());
        t2.setTitle("Teste 2");
        t2.setStudios("Teste 2");
        t2.setProducers("Teste 2");
        t2.setWinner("Teste 2");

        Film r2 = this.filmService.create(t2);
        Assert.notNull(r2.getTitle(), "erro ao criar filme c2");


        Film t3 = new Film(null, null, null, null, null);
        t1.setYear(getLocalDate.getYear());
        t3.setTitle("Teste 3");
        t3.setStudios("Teste 3");
        t3.setProducers("Teste 3");
        t3.setWinner("Teste 3");

        Film r3 = this.filmService.create(t3);
        Assert.notNull(r3.getTitle(), "erro ao criar filme c3");
    }

    @Test
    public void listAllFilm() {
        List<Film> r1 = this.filmService.listAll();
        Assert.notNull(r1.size() == 0, "erro ao listar os filmes");
    }
    
    @Test
    public void findByTitle() {
        Film r1 = this.filmService.findById(1);
        Assert.notNull(r1.getTitle(), "erro ao buscar filme");
    }
    
    @Test
    public void updateFilm() {
        Date date = new Date(0);
        ZoneId timeZone = ZoneId.systemDefault();
        LocalDate getLocalDate = date.toInstant().atZone(timeZone).toLocalDate();
    	Film t1 = new Film(null, null, null, null, null);
        t1.setYear(getLocalDate.getYear());
        t1.setTitle("Teste 1");
        t1.setStudios("Teste 1");
        t1.setProducers("Teste 1");
        t1.setWinner("Teste 1");

        Film r1 = this.filmService.update(t1);
        Assert.notNull(r1.getTitle(), "erro ao atualizar filme t1");
    }
    
    @Test
    public void deleteFilm() {    	
        this.filmService.delete(1);
    }
}
