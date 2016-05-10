package com.seismaismais.stronger.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_musclegroup")
public class MuscleGroup implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "musclegroup_seq", sequenceName = "tb_musclegroup_seq")
	@GeneratedValue(generator = "musclegroup_seq", strategy = GenerationType.IDENTITY)
	@Column(name = "cod_musclegroup")
	private Long codMuscleGroup;

	@Column(name = "name_musclegroup", nullable = false)
	private String nameMuscleGroup;

	public Long getCodMuscleGroup() {
		return codMuscleGroup;
	}

	public void setCodMuscleGroup(Long codMuscleGroup) {
		this.codMuscleGroup = codMuscleGroup;
	}

	public String getNameMuscleGroup() {
		return nameMuscleGroup;
	}

	public void setNameMuscleGroup(String nameMuscleGroup) {
		this.nameMuscleGroup = nameMuscleGroup;
	}

}
