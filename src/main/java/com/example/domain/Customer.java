package com.example.domain;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity		// JPA entity암을 표시함
@Table(name = "customers") // (2)	// 이 entity에 db talbe을 지정함
@Data
@AllArgsConstructor	//JPA Entiry눈 parameter없는 기본 consturctor가 필수임
@NoArgsConstructor
public class Customer{
	@Id		// Entity의 primary key field를 지정함
	@GeneratedValue	// primary key field를 자동으로 매기도록 지정함.
    private Integer id;
	@Column(nullable = false)
	private String firstName;	// Java notation firstName db field notation first_name 이 convention
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = true)
	private String email;

}



/* --> jdbc
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Integer id;
    private String firstName;
    private String lastName;

}
<--*/