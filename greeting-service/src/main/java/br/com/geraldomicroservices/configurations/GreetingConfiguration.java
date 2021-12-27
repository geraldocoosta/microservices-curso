package br.com.geraldomicroservices.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@ConfigurationProperties("greeting-service")
@Getter
@Setter
@NoArgsConstructor
public class GreetingConfiguration {
	
	
	private String greeting;
	private String defaulValue;
	
	
}
