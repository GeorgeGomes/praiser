package com.seismaismais.praiser.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BACKGROUND")
public class Background implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BACKGROUND_ID")
	private Long backgroundId;
	
	@Column(name="BACKGROUND", nullable=false)
	private String background;
	
	@Column(name="COLOR_TITLE", nullable=false)
	private String colorTitle;
	
	@Column(name="COLOR_BODY", nullable=false)
	private String colorBody;
	
	@Column(name="FILENAME", nullable=true)
	private String filename;

	public Long getBackgroundId() {
		return backgroundId;
	}

	public void setBackgroundId(Long backgroundId) {
		this.backgroundId = backgroundId;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public String getColorTitle() {
		return colorTitle;
	}

	public void setColorTitle(String colorTitle) {
		this.colorTitle = colorTitle;
	}

	public String getColorBody() {
		return colorBody;
	}

	public void setColorBody(String colorBody) {
		this.colorBody = colorBody;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
