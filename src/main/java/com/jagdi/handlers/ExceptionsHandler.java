package com.jagdi.handlers;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jagdi.exceptions.NoDataException;
import com.jagdi.entities.ExceptionLog;
import com.jagdi.repositories.ExceptionLogRepository;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

	@Autowired
	ExceptionLogRepository exceptionLogRepository;

//	@ExceptionHandler({ NoDataException.class,Exception.class })
//	public ResponseEntity noDataException(Exception e) {
//		exceptionLogRepository.save(new ExceptionLog(getPrintStackTrace(e), e.getDescription(), e.getData()));
//		return new ResponseEntity<String>("Internal Server Error",HttpStatus.INTERNAL_SERVER_ERROR);
//	}

	public String getPrintStackTrace(Exception e) {
		StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter(errors));
		return errors.toString();
	}

}
