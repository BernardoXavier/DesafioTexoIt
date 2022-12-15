package br.com.texoit.projeto.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import br.com.texoit.projeto.model.Film;
import br.com.texoit.projeto.model.Indicated;
import br.com.texoit.projeto.repository.FilmRepository;

/**
 * Classe responsável por executar serviços de regras.

 * @author Bernardo Xavier
 * 

*/
@Service
@Transactional(readOnly = true)
public class FilmService {
	
	@Autowired
    private FilmRepository filmRepository;
	
	/** Método que retorna uma lista de filmes

     *   @return List - Films
    */
	public List<Film> listAll() {
        return this.filmRepository.findAll();
    }
	
	/** Método que busca e retorna um filme pelo Id

     *   @return Film
    */
	public Film findById(Integer id) {
        Film film = this.filmRepository.findById(id).get();
        Assert.notNull(film, "film não encontrada.");
        return film;
    }
	
	/*
	 * 
	 * * Método que insere um novo filme

    */
	@Transactional()
    public Film create(Film film) throws IllegalArgumentException {
        Assert.notNull(film, "film não pode ser nulo.");
        return this.filmRepository.save(film);
    }

	/** Método que atualiza o filme

     *
    */
    @Transactional()
    public Film update(Film film) throws IllegalArgumentException {
        Film c = this.findById(film.getId());
        Assert.notNull(c, "Filme não encontrado");

        return this.filmRepository.save(film);
    }

    /** Método que exclui um filme

     * 
    */
    @Transactional()
    public void delete(@NotNull Integer id) throws IllegalArgumentException {
        this.filmRepository.findById(id).ifPresent(this.filmRepository::delete);
    }
    /** Método que limpa tabela filme

     * 
    */
    @Transactional()
    public void deleteAll() throws IllegalArgumentException {
        ArrayList<Film> Films = (ArrayList<Film>) this.filmRepository.findAll();
        for (Film film : Films) {
            this.filmRepository.delete(film);
        }
    }

    /** Método que busca os indicados ao prêmio

     *
    */
    @Transactional()
    public HashMap<String, ArrayList<Indicated>> findlistOfNominees() {
        HashMap<String, ArrayList<Indicated>> map = new HashMap<>();
        ArrayList<Indicated> min = this.buildIndicated(this.filmRepository.findMinIndicated());
        ArrayList<Indicated> max = this.buildIndicated(this.filmRepository.findMaxIndicated());
        map.put("min", min);
        map.put("max", max);

        return map;
    }

    private ArrayList<Indicated> buildIndicated(List<Object[]> list) {
        ArrayList<Indicated> listIndicated = new ArrayList<>();
        for (Object[] item : list) {
            Indicated indicated = new Indicated(String.valueOf(item[0]),
                    String.valueOf(item[3]),
                    String.valueOf(item[1]),
                    String.valueOf(item[2]));
            listIndicated.add(indicated);
        }
        return listIndicated;
    }
}
