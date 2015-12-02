package com.bkweb.common.entity.json;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component("myObjectMapper")
public class MyObjectMapper extends ObjectMapper {

	private static final long serialVersionUID = 1L;

	public MyObjectMapper() {
		super();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		setDateFormat(dateFormat);
		setSerializationInclusion(Include.NON_NULL);
		
		setAnnotationIntrospector(new MyAnnotationIntrospector());
	}

}
