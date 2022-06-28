package com.sit.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.sit.exception.CustomException;
import com.sit.exception.ErrorMessages;

@Component
public class Mapper {

	public <T> T convert(Object srcObj, Class<T> targetClass) {
		T response = null;

		try {
			response = new ModelMapper().map(srcObj, targetClass);
		} catch (Exception e) {
			throw new CustomException("Error while converting object", e, ErrorMessages.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

}
