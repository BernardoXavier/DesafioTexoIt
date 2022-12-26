package br.com.texoit.projeto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe para objetos do tipo film, onde serão contidos, valores e métodos para o mesmo.

 * @author Bernardo Xavier
 * 

*/
@Entity
@Table(name = "film")
public class Film implements Serializable {
	public Film() {};

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

	@Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "title", nullable = false)
    private String title;
    
    @Column(name = "studios", nullable = false)
    private String studios;

	@Column(name = "producers", nullable = false)
    private String producers;

	@Column(name = "winner", nullable = true)
    private String winner;	

	public Film(Integer year, String title, String studios, String producers, String winner) {
    super();
	this.year = year;
	this.title = title;
	this.studios = studios;
	this.producers = producers;
	this.winner = winner;
	}

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	public String getStudios() {
		return studios;
	}

	public void setStudios(String studios) {
		this.studios = studios;
	}

	public String getProducers() {
		return producers;
	}

	public void setProducers(String producers) {
		this.producers = producers;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", year=" + year + ", title=" + title + ", studios=" + studios + ", producers="
				+ producers + ", winner=" + winner + "]";
	}

	
	
}
