package br.com.geraldomicroservices.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Greeting {

	private long id;
	private String content;

}
