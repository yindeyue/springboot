package com.yindeyue.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@RequestMapping(value = "get", method = RequestMethod.GET)
	public String get(String a) {
		return "get:" + a;
	}

	@RequestMapping(value = "post", method = RequestMethod.POST)
	public String post(String a) {
		return "post:" + a;
	}

	@RequestMapping(value = "put", method = RequestMethod.PUT)
	public String put(String a) {
		return "put:" + a;
	}

	@RequestMapping(value = "delete", method = RequestMethod.DELETE)
	public String delete(String a) {
		return "delete:" + a;
	}

	@RequestMapping(value = "putshiyan", method = RequestMethod.PUT)
	public String putShiyan(String shiyan) {
		return shiyan;
	}
}
