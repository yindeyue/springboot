package com.yindeyue.entity;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

public class MyMessageConverter extends AbstractHttpMessageConverter<Person> {

	public MyMessageConverter() {
		super(new MediaType("application", "yindeyue", Charset.forName("utf-8")));
	}

	@Override
	protected boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Person.class.isAssignableFrom(clazz);
	}

	@Override
	protected Person readInternal(Class<? extends Person> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		System.out.println(inputMessage.getHeaders());
		String temp = StreamUtils.copyToString(inputMessage.getBody(), Charset.forName("UTF-8"));
		String[] tempArr = temp.split("-");
		System.out.println(tempArr);
		return new Person(Integer.parseInt(tempArr[0]), tempArr[1], Integer.parseInt(tempArr[2]));
	}

	@Override
	protected void writeInternal(Person person, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		String out = "hello: " + person.getId() + "-" + person.getName()+ "-" + person.getAge();
        outputMessage.getBody().write(out.getBytes());

	}

}
