package org.modelmapper.gh254.web;

import org.modelmapper.ModelMapper;
import org.modelmapper.gh254.mod.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Gh254Application {
	public static void main(String[] args) {
		SpringApplication.run(Gh254Application.class, args);
	}

	@Autowired
	private ModelMapper modelMapper;

	@RequestMapping
	public Dto dto() {
		return modelMapper.map(new Request("2", "chhsiao90@gmail.com"), Dto.class);
	}
}
