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

    private String interval;

    private String previuosWin;
    
    private String followingWin;

	public Indicated(String producer, String interval, String previuosWin, String followingWin) {
		super();
		this.producer = producer;
		this.interval = interval;
		this.previuosWin = previuosWin;
		this.followingWin = followingWin;
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

	public String getInterval() {
		return interval;
	}

	public void setInterval(String interval) {
		this.interval = interval;
	}

	public String getPreviuosWin() {
		return previuosWin;
	}

	public void setPreviuosWin(String previuosWin) {
		this.previuosWin = previuosWin;
	}

	public String getFollowingWin() {
		return followingWin;
	}

	public void setFollowingWin(String followingWin) {
		this.followingWin = followingWin;
	}
	
	
}
