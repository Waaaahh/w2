package com.jdbcex.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public enum MapperUtil {
	
	INSTANCE;
	
	private ModelMapper modelMapper;
	
	MapperUtil() {
		this.modelMapper = new ModelMapper();
		this.modelMapper.getConfiguration()
						.setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
						.setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	public ModelMapper test() {
		return modelMapper;
	}
	
	public ModelMapper get() {
		return modelMapper;
	}
}
