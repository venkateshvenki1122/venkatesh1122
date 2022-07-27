package com.example.demo.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name = "mini_statement")
public class MiniStatement {

	@Id
	@Column(name = "account_number")
	long accountNumber;
	
	
	@OneToMany(targetEntity=TransactionList.class,
			fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	
	@JoinColumn(name="transfer_ref",referencedColumnName = "account_number")
	
	List<TransactionList> patientList;
}
