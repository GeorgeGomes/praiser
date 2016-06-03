package com.seismaismais.praiser.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FONT")
public class Font implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="FONT_ID")
	private Long fontId;
	
	@Column(name="FONT", nullable=false)
	private String font;
	
	@Column(name="FILENAME", nullable=true)
	private String filename;

	public Long getFontId() {
		return fontId;
	}

	public void setFontId(Long fontId) {
		this.fontId = fontId;
	}

	public String getFont() {
		return font;
	}

	public void setFont(String font) {
		this.font = font;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
}
