package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="venki_insurance_master")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="insurance_type",length = 40,
			discriminatorType = DiscriminatorType.STRING)
public class Insurance {

	@Id
	@Column(name="policy_number")
	private int policyNumber;
	
	@Column(name="policy_holder_name")
	private String policyHolderName;
}
