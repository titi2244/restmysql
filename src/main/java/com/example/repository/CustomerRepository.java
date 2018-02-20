package com.example.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
///*
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.domain.Customer;

//@Repository <- extends JpaRepository 로 필요없음
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	// extends JpaRepository<Customer, Integer> 만으로 기본 Method - findAll save findOne delete Code가 실행 시 자동 생성됨
	Optional<Customer> findByFirstName(@Param("firstName") String firstName);
	
	//@Query("SELECT x FROM Customer x WHERE x.firstName =:name");
	//List<Customer> findByName(@Param("firstName") String firstName);
	
	//@Query("SELECT x FROM customer x ORDER BY x.firstName, x.lastName")
	@Query("SELECT x FROM Customer x ORDER BY x.firstName, x.lastName")	// Class name and class field not table name and table column name
    Page<Customer> findAllOrderByNamePagable(Pageable pageable);
	
	@Query("SELECT x FROM Customer x ORDER BY x.firstName, x.lastName")	// Class name and class field not table name and table column name
	List<Customer> findAllOrderByName();

	@Query(value = "SELECT id, first_name, last_name FROM customers ORDER BY first_name, last_name", nativeQuery = true)
	List<Customer> findAllOrderByNameWithNativeQuery();
	
}
//*/
/* --> JDBC 사용 code
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.domain.Customer;

@Repository
@Transactional

public class CustomerRepository {
	
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

    SimpleJdbcInsert insert;

	@PostConstruct
	public void init() {
        insert = new SimpleJdbcInsert((JdbcTemplate) jdbcTemplate.getJdbcOperations()) // (1)
                .withTableName("customers") // (2)
                .usingGeneratedKeyColumns("id"); // (3)
  	}
	
	private static final RowMapper<Customer> customerRowMapper = (rs, i) -> {
        Integer id = rs.getInt("id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        return new Customer(id, firstName, lastName);
	};
	
	public List<Customer> findAll(){
		List<Customer> customers = jdbcTemplate.query("SELECT id,first_name,last_name FROM customers ORDER BY id", customerRowMapper);
		return customers;
		
	}
	
	public Customer findOne(Integer id) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		return jdbcTemplate.queryForObject("SELECT id,first_name,last_name FROM customers WHERE id=:id", param, customerRowMapper);
	}
	
	public Customer save(Customer customer) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(customer);
		
		if(customer.getId() == null) {
			//jdbcTemplate.update("INSERT INTO customers(first_name, last_name) values(:firstName, :lastName)", param);
			Number key = insert.executeAndReturnKey(param);
			customer.setId(key.intValue());
		}else {
			jdbcTemplate.update("UPDATE customer SET first_name=:firstName, last_name=:lastName WHERE id=:id", param);
		}
		return customer;
	}
	
	public void delete(Integer id) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id );
		jdbcTemplate.update("DELETE FROM customrer where id=:id" , param);
	}
	
}
<-- */
