package br.com.texoit.projeto.model;

import java.io.Serializable;

/**
 * Classe para objetos do tipo film, onde serão contidos, valores e métodos para o mesmo.

 * @author Bernardo Xavier
 * 

*/
public class Indicated implements Serializable {

	private static final long serialVersionUID = 1L;
	
    private String producer;

    private Integer interval;

    private Integer previuosWin;
    
    private Integer followingWin;

	public Indicated(String producer, String interval, String previuosWin, String followingWin) {
		super();
		this.producer = producer;
		this.interval = Integer.parseInt(interval);
		this.previuosWin = Integer.parseInt(previuosWin);
		this.followingWin = Integer.parseInt(followingWin);
    }

    public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getProducers() {
		return producer;
	}

	public void setProducers(String producers) {
		this.producer = producers;
	}

	public Integer getInterval() {
		return interval;
	}

	public void setInterval(Integer interval) {
		this.interval = interval;
	}

	public Integer getPreviuosWin() {
		return previuosWin;
	}

	public void setPreviuosWin(Integer previuosWin) {
		this.previuosWin = previuosWin;
	}

	public Integer getFollowingWin() {
		return followingWin;
	}

	public void setFollowingWin(Integer followingWin) {
		this.followingWin = followingWin;
	}
	
	
}
