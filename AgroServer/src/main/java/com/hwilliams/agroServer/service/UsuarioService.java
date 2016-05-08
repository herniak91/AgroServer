package com.hwilliams.agroServer.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hwilliams.agroServer.model.Usuario;

@Repository
public class UsuarioService {

	private static final String TABLE_NAME = "comercio";
//	private static final String SELECT_BY_ID = "SELECT * FROM " + TABLE_NAME + " WHERE name='%s' AND lastname '%s'";
	private static final String SELECT_BY_ID = "SELECT * FROM " + TABLE_NAME + " WHERE comercio='%s'";
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Usuario getUserById(String name, String lastname){
		String query  = String.format(SELECT_BY_ID, new String[]{name, lastname});
		return jdbcTemplate.queryForObject(query, new RowMapper<Usuario>(){
			@Override
			public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
				String name = rs.getString("comercio");
				String lastname = "Algo";
				return new Usuario(name, lastname);
			}});
	}
}
