package com.seismaismais.praiser.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

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

	@Column(name="ARTIST", nullable=false)
	private String artist;
	
	@Column(name="MUSIC", nullable=false)
	private String music;
	
	@Column(name="FILENAME", nullable=true)
	private String filename;
	
	@Column(name="SLIDE", nullable=false)
	@Type(type="text")
	private String slide;
	
	@Column(name="WIDTH", nullable=true)
	private Double width;
	
	@Column(name="HEIGHT", nullable=true)
	private Double height;
	

	@Transient
	private String[] slidesImages;
	
	public Long getSlideId() {
		return slideId;
	}

	public void setSlideId(Long slideId) {
		this.slideId = slideId;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getMusic() {
		return music;
	}

	public void setMusic(String music) {
		this.music = music;
	}
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String fileName) {
		this.filename = fileName;
	}

	public String getSlide() {
		return slide;
	}

	public void setSlide(String slide) {
		this.slide = slide;
	}

	public String[] getSlidesImages() {
		return slidesImages;
	}

	public void setSlidesImages(String[] slidesImages) {
		this.slidesImages = slidesImages;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}
	
}
