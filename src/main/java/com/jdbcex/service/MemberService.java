package com.jdbcex.service;

import org.modelmapper.ModelMapper;

import com.jdbcex.dao.MemberDAO;
import com.jdbcex.domain.MemberVO;
import com.jdbcex.dto.MemberDTO;
import com.jdbcex.util.MapperUtil;

import lombok.extern.log4j.Log4j2;

@Log4j2
public enum MemberService {
	
	INSTANCE;
	
	private MemberDAO dao;
	private ModelMapper modelMapper;
	
	private MemberService() {
		dao = new MemberDAO();
		modelMapper = MapperUtil.INSTANCE.get();
	}
	
	public MemberDTO login(String mid, String mpw) throws Exception {
		MemberVO vo = dao.getWithPassword(mid, mpw);
		
		MemberDTO memberDTO = modelMapper.map(vo, MemberDTO.class);
		
		return memberDTO;
	}

}
