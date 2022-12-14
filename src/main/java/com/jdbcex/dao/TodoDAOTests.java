package com.jdbcex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jdbcex.jdbcex.domain.TodoVO;

import lombok.Cleanup;

public class TodoDAOTests {
	
	private TodoDAO todoDAO;
	
	@BeforeEach
	public void ready() {
		todoDAO = new TodoDAO();
	}
	
	@Test
	public void testTime() throws Exception {
		System.out.println(todoDAO.getTime());
	}
	
	public String getTime2() throws Exception {
		@Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
		@Cleanup PreparedStatement preparedStatement = connection.prepareStatement("select now()");
		
		@Cleanup ResultSet resultSet = preparedStatement.executeQuery();
		
		resultSet.next();
		
		String now = resultSet.getString(1);
		
		return now;
	}
	
	@Test
	public void testInsert() throws Exception {
		TodoVO todoVO = TodoVO.builder()
							.title("Sample Title..")
							.dueDate(LocalDate.of(2021, 12,31))
							.build();
		
		todoDAO.insert(todoVO);
	}
	
	@Test
	public void testList() throws Exception {
		
		List<TodoVO> list = todoDAO.selectAll();
		
		list.forEach(vo -> System.out.println(vo));
	}

}
