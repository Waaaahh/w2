package com.jdbcex.service;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jdbcex.dto.TodoDTO;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TodoServiceTests {
	
	private TodoService todoService;
	
	@BeforeEach
	public void ready() {
		todoService = TodoService.INSTANCE;
	}
	
	@Test
	public void testRegister() throws Exception {
		
		TodoDTO todoDTO = TodoDTO.builder()
				.title("JDBC Test Title")
				.dueDate(LocalDate.now())
				.build();
		log.info("-------------------------------------------------"); // 테스트 코드의 Log4j2설정 확인
		log.info(todoDTO);
		
		todoService.register(todoDTO);
		
	}

}
