package br.com.texoit.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.texoit.projeto.model.Film;

/**
 * Classe responsável pelos repositório film.

 * @author Bernardo Xavier
 * 

*/
@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {

    @Query(nativeQuery = true, value = 
    " select producers, min(year) previousWin, max(year) followingWin, max(year) - min(year) interval  from film " +
    " where winner = 'yes' " +
    " group by producers " +
    " having max(year) - min(year) = select decode(min(interval) ,0 ,1) from (select max(year) - min(year) interval from film film2 " +
    " where winner = 'yes' " +
    " group by producers) ")
    List<Object[]> findMinIndicated();

    @Query(nativeQuery = true, value = 
    " select producers, min(year) previousWin, max(year) followingWin, max(year) - min(year) interval  from film " +
    " where winner = 'yes' " +
    " group by producers " +
    " having max(year) - min(year) = select max(interval) from (select max(year) - min(year) interval from film film2 " +
    " where winner = 'yes' " +
    " group by producers) ")
    List<Object[]> findMaxIndicated();

}
