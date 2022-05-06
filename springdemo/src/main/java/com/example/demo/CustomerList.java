package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Component
public class CustomerList {

	List<Customer> custList;
}
