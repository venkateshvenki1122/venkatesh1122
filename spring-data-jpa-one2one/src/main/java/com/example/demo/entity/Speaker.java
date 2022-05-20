package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="venki_speaker")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Speaker {

	@Id
	@Column(name="speaker_id")
	int id;
	
	@Column(name="speaker_name")
	String firstName;
	
	@Column(name="qualification")
	String qualification;
}
