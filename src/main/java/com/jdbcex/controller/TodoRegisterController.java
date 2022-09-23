package com.jdbcex.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdbcex.dto.TodoDTO;
import com.jdbcex.service.TodoService;

import lombok.extern.log4j.Log4j2;

@WebServlet(name = "todoRegisterController")
@Log4j2
public class TodoRegisterController extends HttpServlet {
	
	private TodoService todoService = TodoService.INSTANCE;
	private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("/todo/register GET ..........");
		
		HttpSession session = req.getSession();
		
		if(session.isNew()) {
			log.info("JSESSIONID 쿠키가 새로 만들어진 사용자");
			resp.sendRedirect("/login");
			return;
		}
		//JSESSIONID는 있지만 해다 ㅇ세션 컨텍스트에 loginINfo라는 이름으로 저장된 객체가 없는 경우
		if(session.getAttribute("loginInfo") == null) {
			log.info("로그인한 정보가 없는 사용자");
			resp.sendRedirect("/login");
			return;
		}
		// 정상적인 경우라면 입력화면으로
		req.getRequestDispatcher("/WEB-INF/todo/register.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TodoDTO todoDTO = TodoDTO.builder()
				.title(req.getParameter("title"))
				.dueDate(LocalDate.parse(req.getParameter("dueDate"), DATEFORMATTER))
				.build();
		
		log.info("/todo/register POST...");
		log.info(todoDTO);
		
		try {
			todoService.register(todoDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		resp.sendRedirect("/todo/list");
	}

}
