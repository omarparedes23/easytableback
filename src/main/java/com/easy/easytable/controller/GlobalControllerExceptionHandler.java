package com.easy.easytable.controller;

import com.easy.easytable.dto.ExceptionDto;
import com.easy.easytable.exception.EasyTableException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * Va gerer toutes les exceptions de nos controleurs.
 */
@Log4j2
@ControllerAdvice
public class GlobalControllerExceptionHandler {

	/**
	 * Handles functional exceptions.
	 *
	 * @param pException the targeted exception
	 * @return the HttpStatus and body regarding the exception
	 */
	@ExceptionHandler(EasyTableException.class)
	public ResponseEntity<ExceptionDto> exceptionHandler(EasyTableException pException) {
		var dtoOut = new ExceptionDto(pException);
		return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(dtoOut);
	}

}
