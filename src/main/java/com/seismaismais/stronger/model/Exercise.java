package com.seismaismais.stronger.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb_exercise")
public class Exercise implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="exercise_seq", sequenceName="tb_exercise_seq")
	@GeneratedValue(generator="exercise_seq", strategy=GenerationType.IDENTITY)
	@Column(name="cod_exercise")
	private Long codExercise;
	
	@ManyToOne
	private MuscleGroup muscleGroup;
	
	@Column(name="name_exercise")
	private String nameExercise;

	public Long getCodExercise() {
		return codExercise;
	}

	public void setCodExercise(Long codExercise) {
		this.codExercise = codExercise;
	}

	public MuscleGroup getMuscleGroup() {
		return muscleGroup;
	}

	public void setMuscleGroup(MuscleGroup muscleGroup) {
		this.muscleGroup = muscleGroup;
	}

	public String getNameExercise() {
		return nameExercise;
	}

	public void setNameExercise(String nameExercise) {
		this.nameExercise = nameExercise;
	}
	
}
