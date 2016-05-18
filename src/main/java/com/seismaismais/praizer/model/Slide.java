package com.seismaismais.praizer.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.seismaismais.praizer.auth.data.State;

@Entity
@Table(name="SLIDE")
public class Slide implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SLIDE_ID")
	private Long slideId;

	@Column(name="MUSIC_LETTER", nullable=false)
	private String musicLetter;

	public Long getSlideId() {
		return slideId;
	}

	public void setSlideId(Long slideId) {
		this.slideId = slideId;
	}

	public String getMusicLetter() {
		return musicLetter;
	}

	public void setMusicLetter(String musicLetter) {
		this.musicLetter = musicLetter;
	}
	
}
