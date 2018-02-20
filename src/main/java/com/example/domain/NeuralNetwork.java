package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NeuralNetwork {
	private String nnid;			// NeuralNetwork ID
	private String category;		// Category : Business Definition
	private String subCategory;		// SubCategory
	private String title;			// Title
	private String description;		// Description for neural network
	private String useFlag;			// User("Y") or not("N"?)
	private String modelType;		// type of model
	private String config;			

}
